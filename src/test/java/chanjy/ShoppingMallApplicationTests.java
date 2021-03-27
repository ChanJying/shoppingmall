package chanjy;

import chanjy.mapper.CustomerMapper;
import chanjy.pojo.Customer;
import chanjy.redis.RedisService;
import chanjy.service.CartService;
import chanjy.service.GoodsService;
import chanjy.vo.CartVo;
import chanjy.vo.GoodsVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class ShoppingMallApplicationTests {
    @Autowired
    RedisService redisService;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CartService cartService;
    @Autowired
    GoodsService goodsService;
    @Test
    void contextLoads() {

        List<GoodsVo> goodsVoList = goodsService.queryBySearch("米");
        for (GoodsVo vo : goodsVoList) {
            System.out.println(vo.toString());
        }

    }


}
