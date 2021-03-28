package chanjy.controller;


import chanjy.pojo.Cart;
import chanjy.pojo.Customer;
import chanjy.pojo.Order;
import chanjy.result.Result;
import chanjy.service.CartService;
import chanjy.service.GoodsService;
import chanjy.service.OrderService;
import chanjy.util.Salt;
import chanjy.util.UUIDUtil;
import chanjy.vo.CartVo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Or;
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


    @RequestMapping("/doBuy")
    @ResponseBody
    public Result<Boolean> doBuy(@RequestBody Map<Integer,Integer> orderMap, Customer customer)  {
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
        model.addAttribute("customer",customer);
        List<CartVo> cartVos = cartService.queryCartByCustomerId(customer.getId());
        model.addAttribute("cartVos",cartVos);
        return "cart";
    }
}
