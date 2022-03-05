package com.lw.java.innerclass3;

import java.util.Date;

public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        System.out.println(new Date());

        gc.addEvent(gc.new LightOn(2000000000));

        gc.addEvent(gc.new LightOff(2000000000));

        gc.run();
        System.out.println(new Date());
    }
}
