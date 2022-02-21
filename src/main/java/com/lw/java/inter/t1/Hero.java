package com.lw.java.inter.t1;

public class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim {
    @Override
    public void fly() {
        System.out.println("Hero fly()");
    }

    @Override
    public void swim() {
        System.out.println("Hero swim()");
    }
}
