package edu.miracosta.cs112.finalproject.finalproject;

/**
 * Tester class for the CheckingAccount.
 */
public class CheckingAccountTester {
    public static void main(String[] args) {
        // Create a CheckingAccount instance
        CheckingAccount account = new CheckingAccount("123456", 500.0, 200.0);
        System.out.println("Initial state: " + account);

        // Test deposit
        account.deposit(100);
        System.out.println("After deposit, balance: " + account.getBalance());

        // Test withdrawal with exception handling
        try {
            account.withdraw(750);
            System.out.println("After withdrawal, balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

