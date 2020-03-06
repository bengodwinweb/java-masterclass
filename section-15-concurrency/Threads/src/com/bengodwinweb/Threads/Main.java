package com.bengodwinweb.Threads;

import static com.bengodwinweb.Threads.ThreadColor.ANSI_PURPLE;
import static com.bengodwinweb.Threads.ThreadColor.ANSI_GREEN;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous thread");
            }
        }.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");
    }
}
