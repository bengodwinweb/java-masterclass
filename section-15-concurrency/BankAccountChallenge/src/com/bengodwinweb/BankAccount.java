package com.bengodwinweb;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.bengodwinweb.Main.ANSI_RESET;
import static com.bengodwinweb.Main.ANSI_YELLOW;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                    System.out.println(ANSI_YELLOW + "balance after deposit on " + Thread.currentThread().getName() + " is " + nf.format(balance));
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(ANSI_YELLOW + Thread.currentThread().getName() + " could not get lock");
            }
        } catch(InterruptedException e) {
            System.out.println(ANSI_RESET + "Interrupted exception: " + e.getMessage());
        }

        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                    System.out.println(ANSI_YELLOW + "balance after withdrawal on " + Thread.currentThread().getName() + " is " + nf.format(balance));
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(ANSI_YELLOW + Thread.currentThread().getName() + " could not get lock");
            }
        } catch (InterruptedException e) {
            System.out.println(ANSI_RESET + "Interrupted exception: " + e.getMessage());
        }

        System.out.println("Transaction status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number: " + accountNumber);
    }
}
