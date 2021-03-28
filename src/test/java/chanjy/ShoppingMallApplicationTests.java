package chanjy;

import chanjy.mapper.CustomerMapper;
import chanjy.pojo.Customer;
import chanjy.pojo.Order;
import chanjy.redis.RedisService;
import chanjy.service.CartService;
import chanjy.service.GoodsService;
import chanjy.service.OrderService;
import chanjy.util.UUIDUtil;
import chanjy.vo.CartVo;
import chanjy.vo.GoodsVo;
import chanjy.vo.OrderVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
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
    @Autowired
    OrderService orderService;
    @Test
    void contextLoads() {
        List<OrderVo> orderVos = orderService.selectOrderToOrderVo(8);
        for (OrderVo orderVo : orderVos) {
            System.out.println(orderVo.toString());
        }
    }


}
