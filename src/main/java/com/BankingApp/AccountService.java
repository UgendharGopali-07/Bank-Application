package com.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    AccountService(AccountRepository accountRepository,UserRepository userRepository,UserService userService){
        this.accountRepository=accountRepository;
        this.userRepository=userRepository;
        this.userService=userService;
    }
    public String getAccountById(int id){
        if(accountRepository.getAccountList().containsKey(id)){
            String response="";
            Account acc=accountRepository.getAccountList().get(id);
            response+="Account_Id: "+acc.getAccId()+", Balance: "+acc.getBalance();
            response+=",[ User_Id: "+acc.getUserId()+", User_name: "+userRepository.getUserById(acc.getUserId()).getUserName()+" ]";
            return response;
        }
        return "No such Account found!";
    }
    public String createAccount(Account acc){
        return userService.addAccountToUser(acc);
    }
    public String deleteAccount(int id){
        return userService.deleteAccountById(id);
    }
}
