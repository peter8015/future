package com.future.othertest;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class OtherTest {

    @Test
    public void t1() {
        String s = "1";

        Map<String, String> data = Maps.newHashMap();
        data.put("1", "a");
        data.put("2", "b");
        data.put("3", "c");
        data.put("4", "d");
        data.put("5", "e");

        switch (data.keySet().iterator().next()) {
            case "1":
                System.out.println("a");
                break;
            case "2":
                System.out.println("b");
                break;
            case "3":
                System.out.println("c");
                break;
            default:
                System.out.println("default");

        }
    }
}
