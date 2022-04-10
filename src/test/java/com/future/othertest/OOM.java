package com.future.othertest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * OOM test
 * -Xms 20m  -Xmx 20m
 */
public class OOM {

    static class OOMObject {
    }

    @Test
    public void t1() {
        List<Integer> d = new ArrayList();
        d.add(1);


        List<OOMObject> data = new ArrayList<>();
        while (true) {
            data.add(new OOMObject());
        }



    }

    @Test
    public void t2() {
        ArrayList<String> data = new ArrayList(4);
        data.add("a");
        data.add("b");
        data.add("c");
        data.add("d");

        data.ensureCapacity(5);
        data.add("e");

        for(String a : data) {
            System.out.println(a);
        }
    }
}

