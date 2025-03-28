package edu.miracosta.cs112.finalproject.finalproject;

/**
 * A concrete class representing a checking account.
 */
public class CheckingAccount extends Account {
    private double overdraftLimit;

    /**
     * Constructs a CheckingAccount with the specified account number, balance, and overdraft limit.
     * @param accountNumber the account number
     * @param balance the current balance
     * @param overdraftLimit the allowed overdraft limit
     */
    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Deposits an amount into the account.
     * @param amount the amount to deposit
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        }
    }

    /**
     * Withdraws an amount from the account if within overdraft limits.
     * @param amount the amount to withdraw
     * @throws InsufficientFundsException if the withdrawal exceeds the overdraft limit
     */
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > 0) {
            if (getBalance() - amount < -overdraftLimit) {
                throw new InsufficientFundsException("Withdrawal exceeds overdraft limit.");
            } else {
                setBalance(getBalance() - amount);
            }
        }
    }

    /**
     * Returns the overdraft limit.
     * @return the overdraft limit
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Sets a new overdraft limit.
     * @param overdraftLimit the new overdraft limit
     */
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Returns a string representation of the CheckingAccount.
     * @return a string describing the account
     */
    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber=" + getAccountNumber() +
                ", balance=" + getBalance() +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }

    /**
     * Compares two CheckingAccount objects based on account number.
     * @param o the object to compare with
     * @return true if account numbers are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckingAccount)) return false;
        CheckingAccount ca = (CheckingAccount) o;
        return getAccountNumber().equals(ca.getAccountNumber());
    }

    /**
     * Inner class for handling overdraft protection features.
     */
    public class OverdraftProtection {
        /**
         * Checks if a withdrawal would result in a negative balance.
         * @param amount the withdrawal amount
         * @return true if the account goes negative, false otherwise
         */
        public boolean checkOverdraft(double amount) {
            return (getBalance() - amount) < 0;
        }
    }
}

