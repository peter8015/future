package com.future.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CacheService {

    private final static String KEY_PREFIX = "test";

    @Autowired
    RedisTemplate redisTemplate;


    public <K, V> void add(K key, V value) {

        try {
            if (value != null) {
                redisTemplate.opsForValue().set(KEY_PREFIX + key, value);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("cache data failed!");
        }
    }

    public <K> String get(K key) {
        return (String)redisTemplate.opsForValue().get(key);
    }


}
