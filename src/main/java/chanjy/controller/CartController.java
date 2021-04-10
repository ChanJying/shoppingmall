package chanjy.controller;


import chanjy.exception.GlobalException;
import chanjy.mapper.CustomerMapper;
import chanjy.mapper.GoodsMapper;
import chanjy.pojo.*;
import chanjy.result.CodeMsg;
import chanjy.result.Result;
import chanjy.service.CartService;
import chanjy.service.CustomerService;
import chanjy.service.GoodsService;
import chanjy.service.OrderService;
import chanjy.util.Salt;
import chanjy.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/cart")
@Controller
public class CartController {


    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/doBuy")
    @ResponseBody
    public Result<Boolean> doBuy(@RequestBody Map<Integer,Integer> orderMap, Customer customer)  {
        Address address = customerService.queryAddressByCustomerId(customer.getId());
        if(address==null) throw  new GlobalException(CodeMsg.ADDRESS_NOT_EXIST);
        Order order = new Order();
        order.setCustomerId(customer.getId());
        order.setOrderId(Salt.getOrderId());
        order.setOrderDate(new Date());
        for (Map.Entry<Integer, Integer> entry : orderMap.entrySet()) {
           order.setGoodsId(entry.getKey());
           order.setGoodsNums(entry.getValue());
           order.setOrderState(0);
           orderService.addOrder(order);
           goodsService.updateGoodsNums(entry.getKey(),entry.getValue());
        }
        return Result.success(true);
    }

    @RequestMapping("/doDelete")
    @ResponseBody
    public Result<Boolean> doDelete(@RequestBody List<Integer>cartArray,Customer Customer){
        cartService.deleteCartByList(cartArray);
        return Result.success(true);
    }



    @RequestMapping("/addCart")
    @ResponseBody
    public Result<Boolean> addCart(Cart cart){
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
        if(customer==null) return "/customer/login";
        model.addAttribute("customer",customer);
        List<CartVo> cartVos = cartService.queryCartByCustomerId(customer.getId());
        model.addAttribute("cartVos",cartVos);
        return "/customer/cart";
    }
}
