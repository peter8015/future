package com.future.controller;


import com.future.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class RedisController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/redis")
    public String getValue() {
        cacheService.add("test1", "test1");
        return cacheService.get("test1");
    }
}