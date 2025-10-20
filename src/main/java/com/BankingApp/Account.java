package com.BankingApp;

import java.util.ArrayList;

public class Account {
    int accId;
    int userId;
    int balance;
    static int accCount=0;

    public int getAccId() {
        return accId;
    }
    public void setAccId(int accId) {
        this.accId = accId;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public static int getAccCount() {
        return accCount;
    }
    Account(int userId){
        accCount++;
        this.accId=accCount;
        this.userId=userId;
        this.balance=0;
    }
}
