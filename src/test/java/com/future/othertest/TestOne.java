package com.future.othertest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestOne {
    public synchronized void method1() {
    }

    public void method2() {
        Object o = new Object();
        synchronized (this) {
        }
    }


    @Test
    public void t1() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        List<String> stringss = Arrays.asList("abc", "cde");

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        for(String s : filtered) {
            System.out.println(s);
        }

    }
}