package com.BankingApp;

import java.util.ArrayList;

public class User {
    int userId;
    String userName;
    ArrayList<Account> accountList;
    ArrayList<Account> watchList;
    static int userCount=0;

    User(String userName){
        userCount++;
        this.userId=userCount;
        this.userName=userName;
        this.accountList=new ArrayList<>();
        this.watchList=new ArrayList<>();
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getUserId() {
        return userId;
    }
    public void setId(int id) {
        this.userId = id;
    }
    public ArrayList<Account> getAccountList() {
        return accountList;
    }
    public ArrayList<Account> getWatchList() {
        return watchList;
    }
    public static int getUserCount() {
        return userCount;
    }
}
