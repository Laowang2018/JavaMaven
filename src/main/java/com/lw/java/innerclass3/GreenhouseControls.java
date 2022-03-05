package com.lw.java.innerclass3;

public class GreenhouseControls extends Controller{
    private boolean light = false;
    public class LightOn extends Event {
        @Override
        public void action() {
            light = true;
        }

        public String toString() {
            return "Light is on";
        }

        public LightOn(long delayTime) {
            super(delayTime);
        }
    }
    public class LightOff extends Event {
        @Override
        public void action() {
            light = false;
        }
        public String toString(){
            return "Light is off";
        }
        public LightOff(long delayTime) {
            super(delayTime);
        }
    }
}
