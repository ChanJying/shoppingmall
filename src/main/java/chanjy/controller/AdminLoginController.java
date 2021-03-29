package chanjy.controller;


import chanjy.exception.GlobalException;
import chanjy.pojo.Admin;
import chanjy.result.CodeMsg;
import chanjy.result.Result;
import chanjy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminLoginController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/admin/login","/admin"})
    public String toAdminLogin(){
        return "login";
    }
    @RequestMapping("/admin/index")
    public String toAdminIndex(){
        return "index";
    }

    @RequestMapping("/admin/doLogin")
    @ResponseBody
    public Result<Boolean> doLogin(Admin admin){
        Admin admin1 = adminService.selectAdmin(admin);
        if(admin1 == null) throw new GlobalException(CodeMsg.ADMIN_NOT_EXIST);
        return Result.success(true);
    }
}
