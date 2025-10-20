package com.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final DeletionService deletionService;

    UserService(UserRepository userRepository,AccountRepository accountRepository,DeletionService deletionService){
        this.userRepository=userRepository;
        this.accountRepository=accountRepository;
        this.deletionService=deletionService;
    }

    public String addUser(User user){
        if(userRepository.addUser(user)){
            return "User added successfully.";
        }
        return "User cannot be added!";
    }
    public String getAllUsers(){
        StringBuilder res= new StringBuilder("Users: ");
        for(User user:userRepository.getUsers().values()){
            res.append("\t[ Username: ").append(user.getUserName()).append(", Id: ").append(user.getUserId()).append(" ]\n");
        }
        return res.toString();
    }
    public String getUserdetailsById(int id){
        User user=userRepository.getUserById(id);
        if(user!=null){
            StringBuilder res=new StringBuilder("User: "+user.getUserName()+"\n\tAccounts: ");
            for(Account acc:user.getAccountList()){
                res.append("\n\t").append(acc.getAccId()).append(",");
            }
            return res.toString();
        }
        return "No such user found with given Id";
    }
    public String getAccountListByUserId(int id){
        User u=userRepository.getUserById(id);
        if(u!=null){
            StringBuilder res= new StringBuilder("User: " + u.getUserName() + "\n\tAccountList: ");
            for(Account acc:u.getAccountList()){
                res.append("\n\t").append(acc.getAccId()).append(",");
            }
            return res.toString();
        }
        return "No such user found with given Id!";
    }
    public String getWatchListByUserId(int id){
        User u=userRepository.getUserById(id);
        if(u!=null){
            StringBuilder res= new StringBuilder("User: " + u.getUserName() + "\n\tWatchlist: ");
            for(Account acc:u.getWatchList()){
                res.append("\n").append(acc.getAccId()).append(",");
            }
            return res.toString();
        }
        return "No such user found with given Id!";
    }
    public String addAccountToUser(Account acc){
        User user=userRepository.getUserById(acc.getUserId());
        if(user==null){
            return "User not found!";
        }
        boolean flag= accountRepository.addAccount(acc);
        if(!flag){
            return "Account cannot be added!";
        }
        user.getAccountList().add(acc);
        return "Account added successfully.";
    }
    public String deleteUserById(int id){
        return deletionService.deleteUserById(id);
    }
    public String deleteAccountById(int id){
        return deletionService.deleteAccountById(id);
    }

}
