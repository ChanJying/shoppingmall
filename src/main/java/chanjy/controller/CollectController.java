package chanjy.controller;


import chanjy.pojo.Collect;
import chanjy.pojo.Customer;
import chanjy.result.Result;
import chanjy.service.CollectService;
import chanjy.vo.CollectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;


    @RequestMapping("/selfCollect")
    public String toCollect(Model model,Customer customer){
        List<CollectVo> collectVos = collectService.queryCollectByCustomerId(customer.getId());
        model.addAttribute("collectVos",collectVos);
        model.addAttribute("customer",customer);
        return "/customer/selfCollect";
    }

    @RequestMapping("/deleteCollectId/{collectId}")
    @ResponseBody
    public Result<Boolean>  deleteCollectId(@PathVariable("collectId") int collectId){
        collectService.deleteCollectByCollectId(collectId);
        return Result.success(true);
    }

    @RequestMapping("/deleteCollect")
    @ResponseBody
    public Result<Boolean>  deleteCollect(Collect collect){
        collectService.deleteCollect(collect);
        return Result.success(true);
    }

    @RequestMapping("/addCollect")
    @ResponseBody
    public Result<Boolean>  addCollect(Collect collect){
        collectService.addCollect(collect);
        return Result.success(true);
    }


}
