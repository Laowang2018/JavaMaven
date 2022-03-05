package com.lw.java.innerclass2;

import sun.net.www.protocol.mailto.MailToURLConnection;

public class Parcel10 {
    public Destination destination(final String dest, final float price) {//必须是final因为在匿名内部类中被使用
        return new Destination() {
            private int cost;
            {
                cost = Math.round(price);
                if(cost > 100)
                    System.out.println("Over budget! Cost=" + cost);
            }
            private String lable = dest;
            @Override
            public String readLabel() {
                return lable;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        parcel10.destination("Ajun", 100.51F);
    }
}
