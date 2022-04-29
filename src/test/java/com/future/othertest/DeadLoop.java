package com.future.othertest;

public class DeadLoop {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoop!");
            while (true) {
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start!");

                DeadLoop dl = new DeadLoop();
                System.out.println(Thread.currentThread() + " run over!");
            }
        };

        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
    }
}
