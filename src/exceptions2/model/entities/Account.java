package exceptions2.model.entities;

import exceptions2.model.exception.ExceededLimit;
import exceptions2.model.exception.UnavailableBalance;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(Double depositValue) {
        this.balance += depositValue;
    }

    public void withdraw(Double amount) {
        validateWithdraw(amount);
        balance -= amount;
    }

    public void validateWithdraw(Double amount) {
        if (amount > withdrawLimit)
            throw new ExceededLimit("The amount exceeds withdraw limit");
        if (amount > balance)
            throw new UnavailableBalance("Not enough balance");
    }
}
