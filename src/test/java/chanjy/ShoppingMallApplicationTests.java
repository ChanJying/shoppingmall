package chanjy;

import chanjy.redis.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ShoppingMallApplicationTests {
    @Autowired
    RedisService redisService;

    @Test
    void contextLoads() {
    }


}
