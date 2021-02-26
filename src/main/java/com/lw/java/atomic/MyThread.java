package com.lw.java.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private AtomicInteger amount;
    public MyThread(AtomicInteger atomicInteger) {
        this.amount = atomicInteger;
    }
    @Override
    public void run() {
        int number = 0;
        while(true) {
            if(number >= 98) break;
            System.out.println((number = amount.getAndIncrement()) + Thread.currentThread().getName());
        }
    }
}
