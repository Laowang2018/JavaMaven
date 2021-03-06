package com.lw.java.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread t1 = new MyThread(atomicInteger);
        t1.setName("a");
        Thread t2 = new MyThread(atomicInteger);
        t2.setName("b");
        t1.start();
        t2.start();
    }
}
