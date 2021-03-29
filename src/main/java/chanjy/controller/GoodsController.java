package chanjy.controller;

import chanjy.pojo.Customer;
import chanjy.pojo.Type;
import chanjy.service.GoodsService;
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
    private GoodsService goodsService;

    @RequestMapping("/list")
    public String toGoodsList(Model model, Customer customer){
        model.addAttribute("customer",customer);
        return "/customer/goodsList";
    }

    @RequestMapping("/list/{typeId}")
    public String getGoodsListByType(Model model, Customer customer, @PathVariable("typeId")int typeId){
        model.addAttribute("customer",customer);
        List<GoodsVo> goodsList = goodsService.queryGoodsByType(typeId);
        Type type = goodsService.queryTypeById(typeId);
        model.addAttribute("typeName",type.getTypeName());
        model.addAttribute("goodsList",goodsList);
        return "/customer/goodsList";
    }
    @RequestMapping("/detail/{id}")
    public String getGoodsDetail(Model model,Customer customer,@PathVariable("id")int goodsId){
        model.addAttribute("customer",customer);
        GoodsVo goods = goodsService.queryGoodsById(goodsId);
        model.addAttribute("goods",goods);
        return "/customer/goodsDetail";
    }

    @RequestMapping("/search/{searchName}")
    public String queryBySearch(Model model,Customer customer,@PathVariable("searchName")String searchName){
        model.addAttribute("customer",customer);
        List<GoodsVo> goodsList = goodsService.queryBySearch(searchName);
        model.addAttribute("goodsList",goodsList);
        return "/customer/goodsList";
    }




}
