package chanjy;

import chanjy.mapper.CustomerMapper;
import chanjy.pojo.Admin;
import chanjy.pojo.Customer;
import chanjy.pojo.Order;
import chanjy.pojo.Type;
import chanjy.redis.RedisService;
import chanjy.service.AdminService;
import chanjy.service.CartService;
import chanjy.service.GoodsService;
import chanjy.service.OrderService;
import chanjy.util.UUIDUtil;
import chanjy.vo.*;
import com.github.pagehelper.PageInfo;
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
    @Autowired
    AdminService adminService;
    @Test
    void contextLoads() {
        List<Admin> admins = adminService.selectAdminByRole();
        for (Admin admin : admins) {
            System.out.println(admin.toString());
        }
    }


}
