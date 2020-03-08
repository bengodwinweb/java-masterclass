package com.bengodwinweb;

// Challenge
// We could have two people using a joint bank account at the same time. Create
// and start two threads that use the same BankAccount instance and an initial
// balance of 1000.00. One will deposit $300.00 into the bank account, and then
// withdraw $50.00. The other will deposit $203.75 and then withdraw $100.00

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345-678", 1000.00);

        // Create and start threads here

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " depositing $100");
                account.deposit(300.00);
                System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " withdrawing $50.00");
                account.withdraw(50.00);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + Thread.currentThread().getName() + " depositing $203.75");
                account.deposit(203.75);
                System.out.println(ANSI_GREEN + Thread.currentThread().getName() + " withdrawing $100.00");
                account.withdraw(100.00);
            }
        });

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}
