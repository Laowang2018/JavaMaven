package com.lw.java.innerclass2;

public class Parcel5 {
    public Destination destination(String s) {
        class PDesination implements Destination {
            private String label;
            @Override
            public String readLabel() {
                return label;
            }
            private PDesination(String whereTo) {
                label = whereTo;
            }
        }
        return new PDesination(s);
    }
}
