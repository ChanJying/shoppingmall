package chanjy.controller;


import chanjy.pojo.Cart;
import chanjy.pojo.Customer;
import chanjy.result.Result;
import chanjy.service.CartService;
import chanjy.vo.CartVo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/cart")
@Controller
public class CartController {

    @Autowired
    private CartService cartService;


    @RequestMapping("/addCart")
    @ResponseBody
    public Result<Boolean> addCart(Cart cart){
        System.out.println(cart.getGoodsNums());
        Cart cart1 = cartService.queryCartByCustomerIdGoodsId(cart);
        if(cart1!=null){
            cartService.updateCart(cart);
        }else {

            cartService.addCart(cart);
        }
        return Result.success(true);
    }

    @RequestMapping("/deleteCart/{cartId}")
    @ResponseBody
    public Result<Boolean> deleteCart(@PathVariable("cartId")int cartId){
        cartService.deleteCart(cartId);
        return Result.success(true);
    }



    @RequestMapping("/toCart")
    public String toCart(Model model, Customer customer){
        model.addAttribute("customer",customer);
        List<CartVo> cartVos = cartService.queryCartByCustomerId(customer.getId());
        model.addAttribute("cartVos",cartVos);
        return "cart";
    }
}
