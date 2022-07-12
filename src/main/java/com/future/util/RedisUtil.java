package com.future.util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

public class RedisUtil {

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        if(redisTemplate != null) {
            System.out.println("not null");
        } else {
            System.out.println("is null");
        }

        if(stringRedisTemplate == null) {
            System.out.println("stringRedisTemplate is null");
        }
    }

    @Test
    public void testForValue1(){
        String key = "zszxz";
        String value = "知识追寻者";
        redisTemplate.opsForValue().set(key, value);
    }
}
