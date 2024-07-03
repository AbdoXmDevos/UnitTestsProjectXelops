package com.abdoxm.xelops;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
    }
    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
        } else {
            throw new IllegalArgumentException("Invalid transfer amount");
        }
    }
}
