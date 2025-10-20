package com.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/all")
    public String getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id){
        return userService.getUserdetailsById(id);
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUserById(id);
    }
    @GetMapping("/{id}/getAccounts")
    public String getAccountList(@PathVariable int id){
        return userService.getAccountListByUserId(id);
    }

    @GetMapping("/{id}/getWatchlist")
    public String getWatchlist(@PathVariable int id){
        return userService.getWatchListByUserId(id);
    }

}
