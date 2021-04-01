package chanjy.controller;


import chanjy.pojo.Address;
import chanjy.pojo.Customer;
import chanjy.result.Result;
import chanjy.service.CustomerService;
import chanjy.service.OrderService;
import chanjy.vo.OrderDetailVo;
import chanjy.vo.OrderVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

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


    @RequestMapping("/admin/orderList")
    public String getAllOrder(Model model, @RequestParam(value = "pageNum") int pageNum){
        PageInfo<OrderDetailVo> pageInfo = orderService.selectAllByPage(pageNum, 10);
        model.addAttribute("pageInfo",pageInfo);
        List<OrderDetailVo> orderDetailVos = pageInfo.getList();
        model.addAttribute("orderDetailVos",orderDetailVos);
        return "index";
    }

    @RequestMapping("/admin/orderState/{orderState}")
    public String getAllOrder(Model model,@PathVariable("orderState")int orderState,
                              @RequestParam(value = "pageNum") int pageNum){
        PageInfo<OrderDetailVo> pageInfo = orderService.selectAllByState(orderState,pageNum, 10);
        model.addAttribute("pageInfo",pageInfo);
        List<OrderDetailVo> orderDetailVos = pageInfo.getList();
        model.addAttribute("orderDetailVos",orderDetailVos);
        model.addAttribute("orderState",orderState);
        return "orderState";
    }

    @RequestMapping("/admin/orderDetail")
    public String getOrderDetail(Model model,@RequestParam(value = "orderId")String orderId,
                                 @RequestParam(value = "customerId")int customerId){
        List<OrderDetailVo> orderDetailVos = orderService.selectOrderDetailByOrderId(orderId);
        OrderVo orderVo = orderService.selectOrderToOrderVoByOrderId(orderId);
        Address address = customerService.queryAddressByCustomerId(customerId);
        model.addAttribute("orderDetailVos",orderDetailVos);
        model.addAttribute("orderVo",orderVo);
        model.addAttribute("address",address);
        return "orderDetail";
    }

    @RequestMapping("/orderDelivery")
    @ResponseBody
    public Result<Boolean> orderDelivery(String orderId){
        orderService.orderDeliveryByOrderId(orderId);
        return Result.success(true);
    }




}
