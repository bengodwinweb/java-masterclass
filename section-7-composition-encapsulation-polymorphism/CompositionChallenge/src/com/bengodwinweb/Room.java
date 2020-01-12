package com.bengodwinweb;

import java.awt.*;

public class Room {
    private Door door;
    private Window window;
    private Light light;
    private String name;

    public Room(Door door, Window window, Light light, String name) {
        this.door = door;
        this.window = window;
        this.light = light;
        this.name = name;
    }

    public void enterRoom() {
        System.out.println("Entering the " + name);
        door.open();
        light.turnOn();
    }

    public void leaveRoom() {
        System.out.println("Leaving the " + name);
        window.close();
        light.turnOff();
        door.close();
        System.out.println("Left " + name);
    }

    public void freshenUp() {
        System.out.println("Freshening up " + name);
        window.open();
        door.open();
        clean();
    }

    private void clean() {
        System.out.println("Cleaned " + name);
    }
}
