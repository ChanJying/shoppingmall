package chanjy.redis;


import chanjy.redis.prefix.KeyPrefix;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * 获取单个对象
     * */
    public <T> T get(KeyPrefix prefix,String key,Class<T> clazz){
        String realKey = prefix.getPrefix()+key;
        String str = (String)redisTemplate.opsForValue().get(realKey);
        T t = stringToBean(str,clazz);
        return t;
    }

    /**
     * 设置对象
     * */
    public <T> boolean set(KeyPrefix prefix,String key,T value){
        String str = beanToString(value);
        if(str == null || str.length()<0) return false;
        String realKey = prefix.getPrefix()+key;
        int seconds = prefix.expireSeconds();
        if(seconds<=0){
            redisTemplate.opsForValue().set(realKey,str);
        }else{
            redisTemplate.opsForValue().set(realKey,str,seconds,TimeUnit.SECONDS);
        }
        return true;
    }
    /**
     * 判断key是否存在
     * */
    public <T> boolean exists(KeyPrefix prefix, String key) {
        String realKey  = prefix.getPrefix() + key;
        return  redisTemplate.hasKey(realKey);
    }


    /**
     * 增加值
     * */
    public <T> Long incr(KeyPrefix prefix, String key) {
        String realKey  = prefix.getPrefix() + key;
        return  redisTemplate.opsForValue().increment(realKey);
    }

    /**
     * 减少值
     * */
    public <T> Long decr(KeyPrefix prefix, String key) {
        String realKey  = prefix.getPrefix() + key;
        return  redisTemplate.opsForValue().decrement(realKey);
    }

    /**
     * 删除
     * */
    public  boolean delete(KeyPrefix prefix, String key) {
        String realKey  = prefix.getPrefix() + key;
        return  redisTemplate.delete(realKey);
    }

    public <T>void set(String key,T value) {
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            String str = "" + value;
            redisTemplate.opsForValue().set(key, str, 30, TimeUnit.SECONDS);
        }else {
            redisTemplate.opsForValue().set(key, value, 30, TimeUnit.SECONDS);
        }
    }
    public void delete(String key){
        redisTemplate.delete(key);
    }

    public String get(String key){
        return (String)redisTemplate.opsForValue().get(key);
    }

    public static <T> String beanToString(T value){
        if(value==null) return null;
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class ){
            return ""+value;
        }else if(clazz == String.class) {
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class) {
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }
    }

    public static  <T>  T stringToBean(String str, Class<T> clazz) {
        if(str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if(clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class) {
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class) {
            return  (T)Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

}
