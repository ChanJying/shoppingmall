package chanjy.controller;


import chanjy.pojo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OrderController {

    @RequestMapping("/orderDetail")
    public String toOrderDetail(Model model, Customer customer){
        model.addAttribute("customer",customer);
        return "orderDetail";
    }


}
