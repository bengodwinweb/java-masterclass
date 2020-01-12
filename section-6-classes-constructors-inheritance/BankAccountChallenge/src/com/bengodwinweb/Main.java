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

        VipCustomer vip1 = new VipCustomer();
        VipCustomer vip2 = new VipCustomer("Bob Customer", "bob@customer.com");
        VipCustomer vip3 = new VipCustomer("Skitch Customer", 123.00, "skitch@thecustomer.net");

        System.out.println("Customer Name: " + vip1.getCustomerName());
        System.out.println("Customer Email: " + vip1.getEmail());
        System.out.println("Credit Limit: " + vip1.getCreditLimit());
        System.out.println("************");
        System.out.println();

        System.out.println("Customer Name: " + vip2.getCustomerName());
        System.out.println("Customer Email: " + vip2.getEmail());
        System.out.println("Credit Limit: " + vip2.getCreditLimit());
        System.out.println("************");
        System.out.println();

        System.out.println("Customer Name: " + vip3.getCustomerName());
        System.out.println("Customer Email: " + vip3.getEmail());
        System.out.println("Credit Limit: " + vip3.getCreditLimit());
        System.out.println("************");
    }
}
