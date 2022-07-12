package com.future.othertest;

public class TestOne {
    public synchronized void method1() {}

    public void method2() {
        Object o = new Object();
        synchronized(this) {}
    }
}