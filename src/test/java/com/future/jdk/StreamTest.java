package com.future.jdk;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    private StopWatch stopWatch = new StopWatch();

    //    @Test
    public void t3() {
        List<String> nameLists = Arrays.asList("Lvshen", "Lvshen", "Zhouzhou", "Huamulan", "Huamulan", "Huamulan");
        Map<String, Long> nameMap = nameLists.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        nameMap.entrySet().stream().forEach(e ->
                System.out.println(String.format("key:%s,value:%d", e.getKey(), e.getValue())));
    }

    @Test
    public void t2() throws InterruptedException {
        Set<Float> data = new TreeSet();
        Random r = new Random(100);
        for (int i = 0; i < 100; i++) {
            data.add(r.nextFloat());
        }

        data.stream().forEach(f -> System.out.println(f));
    }

    @Test
    public void t4() {
//        List<String> names = Lists.newArrayList();
//        getTestData(names);
        List<String> data = Arrays.asList("a", "b", "a", "b", "c");

//        Map<String, Integer> nameMap = Maps.newHashMap();
//        names.forEach(name -> nameMap.compute(name, (k, v) -> v == null ? 1 : ++v));

//        nameMap.entrySet().stream().forEach(e -> {
//            System.out.println(String.format("key:%s, value:%d", e.getKey(), e.getValue()));
//        });

        Map<String, Long> nameMaps = data.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        nameMaps.entrySet().stream().forEach(e -> {
            System.out.println(String.format("key:%s, value:%d", e.getKey(), e.getValue()));
        });
    }

    private void getTestData(List<String> names) {

        List<String> data = Arrays.asList("a", "b", "a", "b", "c");

        for(int i = 0; i < 10; i++) {
            names.add("names" + i);
        }

        for(int i = 0; i < 5; i++) {
            names.add("names" + i);
        }

//        names.stream().forEach(s -> {
//            System.out.println(s);
//        });
    }
}
