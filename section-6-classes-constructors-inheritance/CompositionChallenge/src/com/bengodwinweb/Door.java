package com.bengodwinweb;

public class Door {
    private boolean isOpen;

    public Door() {
        this(false);
    }

    public Door(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Opened door");
        } else {
            System.out.println("Door is open");
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Closed door");
        } else {
            System.out.println("Door is closed");
        }
    }
}
