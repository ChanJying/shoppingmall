package chanjy.controller;

import chanjy.pojo.Address;
import chanjy.pojo.Customer;
import chanjy.result.Result;
import chanjy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/selfInfo")
public class SelfInfoController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/selfOrder")
    public String toSelfOrder(Model model, Customer customer){
        model.addAttribute("customer",customer);
        return "selfOrder";
    }

    @RequestMapping("/selfAddress")
    public String toSelfAddress(Model model, Customer customer){
        model.addAttribute("customer",customer);
        Address address = customerService.queryAddressByCustomerId(customer.getId());
        model.addAttribute("address",address);
        return "selfAddress";
    }

    @RequestMapping("/setAddress")
    @ResponseBody
    public Result<Boolean> setAddress(Address address){
        Address address1 = customerService.queryAddressByCustomerId(address.getCustomerId());
        if(address1==null){
            customerService.insertAddress(address);
        }else {
            customerService.updateAddress(address);
        }
        return Result.success(true);
    }



}
