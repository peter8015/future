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

    private int stackLen = 1;

    public void stackLeak() {
        stackLen++;
        stackLeak();
    }

    @Test
    public void t1() {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }

    }

    @Test
    public void t2() {

        try {
            stackLeak();
        } catch (Exception e) {
            System.out.println("stackLen:" + stackLen);
        }

    }


    @Test
    public void t3() throws Exception {
        List<OOM> data = new ArrayList();

        Thread.sleep(10 * 1000);
        while (true) {
            data.add(new OOM());
        }
    }

    private static final int _1MB = 1024 * 1024;

    /**
     * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @Test
    public void t4() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];





    }
}