package chanjy.controller;


import chanjy.pojo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/cart")
@Controller
public class CartController {

    @RequestMapping("/toCart")
    public String toCart(Model model, Customer customer){
        model.addAttribute("customer",customer);
        return "cart";
    }
}
