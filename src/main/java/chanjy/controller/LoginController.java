package chanjy.controller;

import chanjy.common.VerifyCode;
import chanjy.pojo.Customer;
import chanjy.result.Result;
import chanjy.service.LoginService;
import chanjy.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private VerifyCode verifyCode;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model,Customer customer){
        model.addAttribute("customer",customer);
        System.out.println(customer.getAccount());
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
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
