package com.bengodwinweb.Threads;

import static com.bengodwinweb.Threads.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run");
    }
}
