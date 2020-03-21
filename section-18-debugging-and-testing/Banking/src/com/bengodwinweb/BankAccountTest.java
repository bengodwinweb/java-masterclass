package com.bengodwinweb;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeAll() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.BeforeEach
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Before each test. Count = " + count++);
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, "balance was not 1200.00 after deposit");
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance,"balance was not 800.00 after withdrawal" );
    }

    @org.junit.jupiter.api.Test
    void withdraw_atm() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600.00, false);
        });
        String expectedMessage = "Cannot withdraw more than 500.00 from an ATM";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), "account balance should be 1200 after deposit");
    }

    @org.junit.jupiter.api.Test
    void isChecking_true() {
        assertTrue(account.isChecking(), "account is not Checking");
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterAll() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }
}