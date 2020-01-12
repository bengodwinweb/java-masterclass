package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("2363209", 250, "Ben Godwin", "ben.godwin1@gmail.com", "540-604-6376");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());
        System.out.println(account.getCustomerName());
        System.out.println(account.getEmail());
        System.out.println(account.getPhoneNumber());

        account.deposit(30);
        account.withdraw(27.13);
        account.withdraw(300);
    }
}
