package chanjy.controller;

import chanjy.exception.GlobalException;
import chanjy.pojo.Customer;
import chanjy.pojo.Goods;
import chanjy.pojo.Type;
import chanjy.result.CodeMsg;
import chanjy.result.Result;
import chanjy.service.GoodsService;
import chanjy.vo.GoodsListVo;
import chanjy.vo.GoodsVo;
import chanjy.vo.OrderDetailVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/admin/goodsList")
    public String getGoodsList(Model model,@RequestParam(value = "pageNum") int pageNum){
        PageInfo<GoodsListVo> pageInfo = goodsService.selectAllToVo(pageNum, 5);
        model.addAttribute("pageInfo",pageInfo);
        List<GoodsListVo> goodsListVos = pageInfo.getList();
        model.addAttribute("goodsListVos",goodsListVos);
        return "goodsList";
    }

    @RequestMapping("/admin/goodsDetail/{goodsId}")
    public String toGoodsDetail(Model model,@PathVariable("goodsId")int goodsId){
        GoodsListVo goodsListVo = goodsService.selectAllToVoByGoodsId(goodsId);
        List<Type> typeList = goodsService.queryType();
        model.addAttribute("goodsListVo",goodsListVo);
        model.addAttribute("typeList",typeList);
        return "goodsDetail";
    }

    @RequestMapping("/admin/addGoods")
    public String addGoods(Model model){
        List<Type> typeList = goodsService.queryType();
        model.addAttribute("typeList",typeList);
        return "addGoods";
    }


    @RequestMapping("/updateGoods")
    @ResponseBody
    public Result<Boolean> updateGoods(Goods goods){
        goodsService.updateGoods(goods);
        return Result.success(true);
    }

    @RequestMapping("/insertGoods")
    @ResponseBody
    public Result<Boolean> insertGoods(Goods goods){
        goodsService.insertGoods(goods);
        return Result.success(true);
    }

    @RequestMapping("/admin/goodsType")
    public String goodsType(Model model){
        List<Type> typeList = goodsService.queryType();
        model.addAttribute("typeList",typeList);
        return "goodsType";
    }
    @RequestMapping("/updateGoodsType")
    public String updateGoodsType(Model model,@RequestParam(value = "id") int id,@RequestParam(value = "typeName") String typeName){
        goodsService.updateGoodsType(id,typeName);
        List<Type> typeList = goodsService.queryType();
        model.addAttribute("typeList",typeList);
        return "goodsType";
    }
    @RequestMapping("/deleteGoodsType")
    public String deleteGoodsType(Model model,@RequestParam(value = "id") int id){
        List<GoodsVo> goodsVoList = goodsService.queryGoodsByType(id);
        if(goodsVoList.isEmpty()){
            goodsService.deleteGoodsType(id);
        }
        return "redirect:/goods/admin/goodsType";
    }
    @RequestMapping("/insertGoodsType")
    @ResponseBody
    public Result<Boolean> insertGoodsType(Model model,String typeName){
        goodsService.insertGoodsType(typeName);
        List<Type> typeList = goodsService.queryType();
        model.addAttribute("typeList",typeList);
        return Result.success(true);
    }



}
