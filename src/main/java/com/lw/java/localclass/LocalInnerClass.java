package com.lw.java.localclass;

import javax.swing.*;

public class LocalInnerClass {
    private int count = 0;
    private class Test{}
    String getString(){
        return null;
    }

    Counter getCounter(final String name) {
        class LocalCounter implements Counter {
            public LocalCounter() {
                System.out.println("LocalCounter()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            @Override
            public int next(){
                System.out.println(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass local = new LocalInnerClass();
        Counter local_inner = local.getCounter("Local inner");
        System.out.println(local_inner.next());
        System.out.println(local_inner.next());
        Counter anonymous_inner = local.getCounter2("anonymous inner");
        System.out.println(anonymous_inner.next());
        System.out.println(anonymous_inner.next());
    }

}
