package com.future.othertest;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void t1() {
        List<String> strings = Arrays.asList("abc", "def", "ghi");
        List<String> filtered =  strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        for(String s : filtered) {
            System.out.println(s);
        }
    }

    @Test
    public void t2() {

        Random r = new Random();
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        r.ints().limit(10000);
        stopWatch.stop();

        stopWatch.start();
        int i = 0;
        while(i <= 1000) {
            RandomUtil.randomInt(100, 10000);
            i++;
        }
        stopWatch.stop();



    }
}
