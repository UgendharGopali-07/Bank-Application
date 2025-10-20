package com.BankingApp;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;

@Repository
public class AccountRepository {
    private final HashMap<Integer,Account> accountList;
    AccountRepository(){
        this.accountList=new HashMap<>();
    }
    public HashMap<Integer, Account> getAccountList() {
        return accountList;
    }

    public boolean addAccount(Account acc){
        try {
            accountList.put(acc.getAccId(),acc);
            return true;
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
    }
    public boolean deleteAccount(int id){
        try {
            accountList.remove(id);
            return true;
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
    }
}
