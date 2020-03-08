package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        // Same code using implementation, anonymous class, and lambda

        new Thread(new CodeToRun()).start();

        // Anonymous
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the anonymous Runnable");
            }
        }).start();

        // Lambda
        new Thread(() -> System.out.println("Printing from the lambda Runnable")).start();

        // Lambda with code block
        new Thread(() -> {
            System.out.println("Printing from the lambda with code block Runnable");
            System.out.println("Still in the lambda wooo");
        }).start();
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the codeToRun Runnable");
    }
}
