package com.bengodwinweb;

import java.text.NumberFormat;

import static com.bengodwinweb.Main.ANSI_YELLOW;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
            System.out.println(ANSI_YELLOW + "balance after deposit on " + Thread.currentThread().getName() + " is " + nf.format(balance));
        }
    }

    public void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
            System.out.println(ANSI_YELLOW + "balance after withdrawal on " + Thread.currentThread().getName() + " is " + nf.format(balance));
        }
    }
}
