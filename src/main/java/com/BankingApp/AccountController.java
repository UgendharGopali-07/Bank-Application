package com.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private final AccountService accService;

    AccountController(AccountService accService){
        this.accService=accService;
    }

    @GetMapping("/{id}")
    public String getAccountBYId(@PathVariable int id){
        return accService.getAccountById(id);
    }

    @PostMapping
    public String addAccount(@RequestBody Account acc){
        return accService.createAccount(acc);
    }

    @DeleteMapping("/{id}")
    public String deleteAccountById(@PathVariable int id){
        return accService.deleteAccount(id);
    }
}
