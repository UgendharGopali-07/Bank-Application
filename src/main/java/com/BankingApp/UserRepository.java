package com.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepository {
    private final HashMap<Integer,User> users;
    UserRepository(){
        this.users=new HashMap<>();
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public User getUserById(int id){
        if(users.containsKey(id)){
            return users.get(id);
        }
        return null;
    }
    public boolean addUser(User user){
        try {
            users.put(user.getUserId(),user);
            return true;
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
    }
    public boolean deleteUser(int id){
        try {
            users.remove(id);
            return true;
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
    }

}
