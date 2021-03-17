package chanjy.service.impl;

import chanjy.mapper.CustomerMapper;
import chanjy.pojo.Customer;
import chanjy.redis.RedisService;
import chanjy.service.LoginService;
import chanjy.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public boolean register(LoginVo loginVo) {



        return true;
    }









}
