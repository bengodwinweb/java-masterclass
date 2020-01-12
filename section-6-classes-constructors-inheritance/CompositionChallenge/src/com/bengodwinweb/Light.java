package com.bengodwinweb;

public class Light {
    private boolean isOn;

    public Light() {
        this(false);
    }

    public Light(boolean isOn) {
        this.isOn = isOn;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Turned on light");
        } else {
            System.out.println("Light is on");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Turned off light");
        } else {
            System.out.println("Light is off");
        }
    }
}
