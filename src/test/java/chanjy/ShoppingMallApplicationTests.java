package chanjy;

import chanjy.mapper.CustomerMapper;
import chanjy.pojo.Customer;
import chanjy.redis.RedisService;
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
    @Test
    void contextLoads() {
        customerMapper.deleteById(6L);

    }


}
