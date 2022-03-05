package com.lw.java.innerclass2;

public class Test {
    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination laowang = p.destination("Laowang");
        String s = laowang.readLabel();
        System.out.println(s);
    }
}
