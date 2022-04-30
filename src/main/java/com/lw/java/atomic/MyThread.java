package com.lw.java.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private AtomicInteger amount;
    public MyThread(AtomicInteger atomicInteger) {
        this.amount = atomicInteger;
    }
    @Override
    public void run() {
        while(true) {
            if(amount.incrementAndGet() >= 98) break;
            System.out.println(amount.get() + Thread.currentThread().getName());
        }
    }
}
