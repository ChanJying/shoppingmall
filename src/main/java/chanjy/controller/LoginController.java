package chanjy.controller;

import chanjy.common.VerifyCode;
import chanjy.pojo.Customer;
import chanjy.pojo.Type;
import chanjy.redis.RedisService;
import chanjy.redis.prefix.IndexPrefix;
import chanjy.result.Result;
import chanjy.service.GoodsService;
import chanjy.service.LoginService;
import chanjy.vo.GoodsVo;
import chanjy.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private VerifyCode verifyCode;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RedisService redisService;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @RequestMapping("/login")
    public String login(){
        return "/customer/login";
    }

    @RequestMapping("/pay")
    public String toPay(){
        return "/customer/pay";
    }

    @RequestMapping(value = {"/index","/"},produces = "text/html")
    @ResponseBody
    public String index(HttpServletRequest request,HttpServletResponse response,Model model,Customer customer){
        model.addAttribute("customer",customer);
        List<GoodsVo> goodsList = goodsService.queryGoodsByLimit();
        model.addAttribute("goodsList",goodsList);
        List<Type> typeList = goodsService.queryType();
        model.addAttribute("typeList",typeList);

        String html =redisService.get(IndexPrefix.getIndex,"",String.class);
        if(!StringUtils.isEmpty(html)){
            return html;
        }
        WebContext ctx =new WebContext(request,response,
                request.getServletContext(),request.getLocale(),model.asMap());

        //手动渲染
        html=thymeleafViewResolver.getTemplateEngine().process("cusindex",ctx);
        if(!StringUtils.isEmpty(html)){
            redisService.set(IndexPrefix.getIndex,"",html);
        }

        return html;
    }

    @RequestMapping("/register")
    public String register(){
        return "/customer/register";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletRequest request,
                                   HttpServletResponse response,
                                   LoginVo loginVo, @RequestParam("uuid")String uuid){
        loginService.login(request,response,loginVo,uuid);
        return Result.success(true);
    }

    @PostMapping("/doRegister")
    @ResponseBody
    public Result<Boolean> doRegister(LoginVo loginVo){
       loginService.register(loginVo);
       return Result.success(true);
    }



    @GetMapping("/verifyCode")
    @ResponseBody
    public void getVerifyCode(HttpServletResponse response, @RequestParam("uuid")String uuid){
        BufferedImage image = verifyCode.createVerifyCode(uuid);
        try{
            OutputStream outputStream = response.getOutputStream();
            ImageIO.write(image,"JPEG",outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
