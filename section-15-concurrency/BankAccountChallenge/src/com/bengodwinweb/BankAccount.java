package com.bengodwinweb;

import static com.bengodwinweb.Main.ANSI_YELLOW;

public class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(ANSI_YELLOW + "balance after deposit is " + balance);
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println(ANSI_YELLOW + "balance after withdrawal on " + Thread.currentThread().getName() + " is " + balance);
    }
}
