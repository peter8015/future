package com.future.util;

import org.junit.Test;

public class CPUTest {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(60 * 60 * 60 * 1000);
//        for(int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while(true) {
//
//                    }
//                }
//            }).start();
//        }

    }



    @Test
    public void t1() {
        int count = 0;


        boolean b = ++count == 0 ? true : false;
        System.out.println(b);

    }
}
