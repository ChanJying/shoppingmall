package chanjy.controller;

import chanjy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;


    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }



    @GetMapping("/verifyCode")
    @ResponseBody
    public void getVerifyCode(HttpServletResponse response, @RequestParam("uuid")String uuid){
        BufferedImage image = loginService.createVerifyCode(uuid);
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
