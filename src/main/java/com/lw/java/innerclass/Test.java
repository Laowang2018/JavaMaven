package com.lw.java.innerclass;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        DonNew donNew = new DonNew();
        DonNew.Inner inner = donNew.new Inner();
        inner.print();

        long l = System.nanoTime();
        System.out.println(l);

        System.out.println(new Date().getTime());
    }
}
