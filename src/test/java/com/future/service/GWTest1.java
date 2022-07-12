package com.future.service;

import com.clearspring.analytics.stream.frequency.CountMinSketch;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * 实现接口访问量统计功能，比如下面的接口
 * /api/location/foo
 * /api/location/bar
 * <p>
 * 1. 接口被访问的时候，访问量加一
 * 2. 返回接口最近5分钟的访问量
 * 3. 支持前缀相同的接口的访问量求和，返回最近五分钟访问量
 */
public class GWTest1 {
    private AtomicInteger counter = new AtomicInteger(0);
    final static String URL = "api/location/foo";
    static Map<String, AtomicInteger> urls = Maps.newConcurrentMap();

    static {
//        urls.put("url", counter);
    }

    ///api/location/foo
    ///api/location/bar
    @Test
    public void test1() {
        int exp = 1;
        int act = count(URL);

        assertEquals(exp, act);
    }


    //Counte reuest
    public Integer count(String url) {

        if (urls.containsKey(url)) {
            urls.get(url).incrementAndGet();
        }
        return urls.get(url).intValue();
    }


    //map(url, counter, time)  1s
    //tuple(url, counter, time)   current - 5 * 60

    //static in 5minute
    public Long countInFive() {


        return 0L;
    }


    //static in 5 minute with pre
    public Long countInFiveWithPre() {


        return 0L;
    }

    @Test
    public void testCountMiniSketch() {
        CountMinSketch countMinSketch = new CountMinSketch(0.001, 0.09, 1);

        countMinSketch.add("75.245.10.1", 1);
        countMinSketch.add("10.125.22.20", 1);
        countMinSketch.add("192.170.0.1", 2);

        System.out.println(countMinSketch.estimateCount("192.170.0.1"));
        System.out.println(countMinSketch.estimateCount("999.999.99.99"));

    }

}
