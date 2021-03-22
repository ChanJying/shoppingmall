package chanjy.service.impl;

import chanjy.exception.GlobalException;
import chanjy.mapper.CustomerMapper;
import chanjy.pojo.Customer;
import chanjy.redis.RedisService;
import chanjy.redis.prefix.CustomerKey;
import chanjy.result.CodeMsg;
import chanjy.service.LoginService;
import chanjy.util.MD5Util;
import chanjy.util.Salt;
import chanjy.util.UUIDUtil;
import chanjy.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

    public static final String COOKIE_NAME_TOKEN="token";

    @Autowired
    private RedisService redisService;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public boolean register(LoginVo loginVo) {
        Customer customer = customerMapper.queryCustomerByAccount(loginVo.getAccount());
        if(customer!=null){
            throw new GlobalException(CodeMsg.ACCOUNT_EXIST);
        }else{
            customer = new Customer();
            //二次加密
            String salt= Salt.getSalt();
            String DBPass= MD5Util.formPassToDBPass(loginVo.getPassword(),salt);
            customer.setAccount(loginVo.getAccount());
            customer.setPassword(DBPass);
            customer.setUsername(loginVo.getUsername());
            customer.setSalt(salt);
            customerMapper.insertCustomer(customer);
            return true;
        }
    }

    @Override
    public boolean login(HttpServletRequest request,HttpServletResponse response, LoginVo loginVo, String uuid) {
        if(loginVo==null) throw new GlobalException(CodeMsg.SERVER_ERROR);
        //验证码比较
        String redisCode = redisService.get(uuid);
        if(!redisCode.equals(loginVo.getVerifyCode())) throw new GlobalException(CodeMsg.VERIFYCODE_ERROR);
        //用户查询是否存在
        String cookieToken = getCookieValue(request,COOKIE_NAME_TOKEN);
        if(!StringUtils.isEmpty(cookieToken)){
            if(redisService.exists(CustomerKey.token,cookieToken)) {
                return true;
            }else {
                getByAccount(response,loginVo);
            }
        }else {
            getByAccount(response,loginVo);
            return true;
        }
        return false;
    }

    public Customer getByToken(HttpServletResponse response,String token){
        if(StringUtils.isEmpty(token)) return null;
        Customer customer = redisService.get(CustomerKey.token,token,Customer.class);
        if(customer!=null){
            addCookie(response,token,customer);
        }
        return customer;
    }
    private void getByAccount(HttpServletResponse response,LoginVo loginVo){
        Customer customer = customerMapper.queryCustomerByAccount(loginVo.getAccount());
        if(customer==null) throw new GlobalException(CodeMsg.ACCOUNT_NOT_EXIST);
        //密码校验
        String DBPass = MD5Util.formPassToDBPass(loginVo.getPassword(),customer.getSalt());
        if(!DBPass.equals(customer.getPassword())) throw new GlobalException(CodeMsg.PASSWORD_MISTAKE);

        String token = UUIDUtil. uuid();
        addCookie(response,token,customer);
    }

    private void addCookie(HttpServletResponse response,String token,Customer customer){
        redisService.set(CustomerKey.token,token,customer);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
        cookie.setMaxAge(CustomerKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[]  cookies = request.getCookies();
        if(cookies == null || cookies.length <= 0){
            return null;
        }
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }


}
