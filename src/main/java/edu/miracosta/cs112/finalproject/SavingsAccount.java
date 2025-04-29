package edu.miracosta.cs112.finalproject;

public class SavingsAccount extends Account {
    public SavingsAccount(String num, double bal, double rate) { super(num, bal); }
    @Override public void deposit(double amt) { }
    @Override public void withdraw(double amt) throws InsufficientFundsException { }
    public void addInterest() { }
    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + getAccountNumber() +
                ", balance=" + getBalance() +
                '}';
    }
}