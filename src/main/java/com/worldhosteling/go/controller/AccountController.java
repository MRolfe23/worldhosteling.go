package com.worldhosteling.go.controller;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> getAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable String id) {
        return accountService.findAccountById(id);
    }

    @GetMapping("/name/{name}")
    public List<Account> getAllAccountsWithNameLike(@PathVariable String name) {
        return accountService.findAllAccountsWhereNameLike(name);
    }

    @GetMapping("/user/{username}" )
    public List<Account> findAllAccountsWhereUserNameLike(@PathVariable String username) {
        return accountService.findAccountByUserName(username);
    }

    @GetMapping("/credential/{email}/{password}")
    public Account verifyAccountCredentials(@PathVariable String email, @PathVariable String password) {
        return accountService.verifyAccountCredentials(email, password);
    }

    @PostMapping("/")
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PostMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }

}
