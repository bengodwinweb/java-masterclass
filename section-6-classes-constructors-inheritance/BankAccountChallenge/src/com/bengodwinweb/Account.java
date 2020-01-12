package com.bengodwinweb;

public class Account {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account() {
        this("-1", 0.00, "Default Name", "Default Email", "Default Phone");
    }

    public Account(String customerName, String email, String phoneNumber) {
        this("-1", 0.00, customerName, email, phoneNumber);
    }

    public Account(String accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double deposit) {
        this.balance += deposit;
        System.out.println("Balance= " + this.balance);
    }

    public void withdraw(double withdrawal) {
        if (this.balance - withdrawal >= 0) {
            this.balance -= withdrawal;
            System.out.println("Balance= " + this.balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
