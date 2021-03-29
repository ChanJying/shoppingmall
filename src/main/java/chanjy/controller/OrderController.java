package chanjy.controller;


import chanjy.pojo.Customer;
import chanjy.result.Result;
import chanjy.service.OrderService;
import chanjy.vo.OrderDetailVo;
import chanjy.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderDetail/{orderId}")
    public String toOrderDetail(Model model, @PathVariable("orderId") String orderId, Customer customer){
        model.addAttribute("customer",customer);
        OrderVo orderVo = orderService.selectOrderToOrderVoByOrderId(orderId);
        List<OrderDetailVo> orders = orderService.selectOrderDetailByOrderId(orderId);
        model.addAttribute("orderVo",orderVo);
        model.addAttribute("orders",orders);
        return "/customer/orderDetail";
    }

    @RequestMapping("/orderConfirm")
    @ResponseBody
    public Result<Boolean> orderConfirm(String orderId){
        orderService.orderConfirmByOrderId(orderId);
        return Result.success(true);
    }



}
