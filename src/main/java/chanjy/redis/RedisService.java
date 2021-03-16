package chanjy.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public <T>void set(String key,T value){

        redisTemplate.opsForValue().set(key,value,30, TimeUnit.SECONDS);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }

    public String get(String key){
        return (String)redisTemplate.opsForValue().get(key);
    }

}
