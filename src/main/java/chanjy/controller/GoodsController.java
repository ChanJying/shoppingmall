package chanjy.controller;

import chanjy.pojo.Customer;
import chanjy.pojo.Type;
import chanjy.result.Result;
import chanjy.service.GoodsService;
import chanjy.service.impl.GoodsServiceImpl;
import chanjy.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @RequestMapping("/list")
    public String toGoodsList(Model model, Customer customer){
        model.addAttribute("customer",customer);
        return "goodsList";
    }

    @RequestMapping("/list/{typeId}")
    public String getGoodsListByType(Model model, Customer customer, @PathVariable("typeId")int typeId){
        model.addAttribute("customer",customer);
        List<GoodsVo> goodsList = goodsService.queryGoodsByType(typeId);
        Type type = goodsService.queryTypeById(typeId);
        model.addAttribute("typeName",type.getTypeName());
        model.addAttribute("goodsList",goodsList);
        return "goodsList";
    }


}
