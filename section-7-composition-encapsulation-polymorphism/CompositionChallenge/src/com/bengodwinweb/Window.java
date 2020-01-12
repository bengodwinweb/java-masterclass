package com.bengodwinweb;

public class Window {
    private boolean isOpen;

    public Window() {
        this(false);
    }

    public Window(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Opened the window");
        } else {
            System.out.println("Window already open");
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Closed the window");
        } else {
            System.out.println("Window already closed");
        }
    }
}
