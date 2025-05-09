package edu.miracosta.cs112.finalproject;

public abstract class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    @Override
    public abstract String toString();
}

