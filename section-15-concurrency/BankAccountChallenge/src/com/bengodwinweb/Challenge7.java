package com.bengodwinweb;

import java.text.NumberFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge7 {
        public static void main(String[] args) {
        BankAccountChallenge7 account1 = new BankAccountChallenge7("12345-678", 500.00);
        BankAccountChallenge7 account2 = new BankAccountChallenge7("98765-432", 1000.00);

        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
    }
}

class BankAccountChallenge7 {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    BankAccountChallenge7(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try {
                // Simulate database access
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                balance -= amount;
                System.out.printf("%s: Withdrew %s\n", Thread.currentThread().getName(), nf.format(amount));
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            try {
                // Simulate database access
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                balance += amount;
                System.out.printf("%s: Deposited %s\n", Thread.currentThread().getName(), nf.format(amount));
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean transfer(BankAccountChallenge7 destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            }
            else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }

        return false;
    }
}

class Transfer implements Runnable {
    private BankAccountChallenge7 sourceAccount, destinationAccount;
    private double amount;

    Transfer(BankAccountChallenge7 sourceAccount, BankAccountChallenge7 destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }
}
