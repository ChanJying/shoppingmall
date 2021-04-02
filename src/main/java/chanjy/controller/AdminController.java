package chanjy.controller;


import chanjy.exception.GlobalException;
import chanjy.pojo.Admin;
import chanjy.pojo.AdminRole;
import chanjy.result.CodeMsg;
import chanjy.result.Result;
import chanjy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/admin/login","/admin"})
    public String toAdminLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping("/admin/doLogin")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletRequest request,String account, String password){
        Admin admin1 = adminService.selectAdmin(account,password);

        if(admin1 == null) throw new GlobalException(CodeMsg.ADMIN_NOT_EXIST);
        AdminRole adminRole = new AdminRole();
        adminRole.setId(admin1.getId());
        adminRole.setAccount(admin1.getAccount());
        adminRole.setPassword(admin1.getPassword());
        adminRole.setRole(admin1.getRole());
        HttpSession session = request.getSession();
        session.setAttribute("admin",adminRole);
        return Result.success(true);
    }

    @RequestMapping("/admin/adminList")
    public String adminList(Model model,HttpServletRequest request){
        AdminRole adminRole = (AdminRole)request.getSession().getAttribute("admin");
        model.addAttribute("adminRole",adminRole);
        List<Admin> admins = adminService.selectAdminByRole();
        model.addAttribute("admins",admins);
        return "adminList";
    }

    @RequestMapping("/admin/insertAdmin")
    @ResponseBody
    public Result<Boolean> insertAdmin(Admin admin){
        adminService.insertAdmin(admin);
        return Result.success(true);
    }

    @RequestMapping("/admin/updateAdmin")
    @ResponseBody
    public Result<Boolean> updateAdmin(Admin admin){
        adminService.updateAdmin(admin);
        return Result.success(true);
    }

    @RequestMapping("/admin/deleteAdmin")
    @ResponseBody
    public Result<Boolean> deleteAdmin(int id){
        adminService.deleteAdmin(id);
        return Result.success(true);
    }

}
