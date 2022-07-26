package com.ty.test.exceptions;

public class CheckingAccount {

    private double balance;
    private int name;

    public CheckingAccount(int num) {
        this.name = num;
    }

    public void deposit(double money) {
        balance += money;
    }

    public void withdraw(double money) throws InsufficientFundsException {
        if (balance >= money) {
            balance -= money;
        } else {
            double need = money - balance;
            throw new InsufficientFundsException(need);
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getName() {
        return name;
    }
}
