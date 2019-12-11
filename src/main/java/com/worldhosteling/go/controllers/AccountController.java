package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
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
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {

        HttpHeaders headers = defaultHeader();

        Account searchAccount = accountService.findAccountById(id);
        if (searchAccount == null) {
            logger.info("Account id: " + id + " Not Found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .headers(headers)
                                 .body(null);
        }

        return ResponseEntity.ok()
                             .headers(headers)
                             .body(searchAccount);
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
    public ResponseEntity<Account> verifyAccountCredentials(@PathVariable String email, @PathVariable String password) {

        HttpHeaders headers = defaultHeader();

        Account verifyAuthentication = accountService.verifyAccountCredentials(email, password);
        if (verifyAuthentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).headers(headers).body(null);
        }

        return ResponseEntity.ok().headers(headers).body(verifyAuthentication);
    }

    @PostMapping("/")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {

        HttpHeaders headers = defaultHeader();

        logger.info(account.toString());
        Account savedAccount = accountService.saveAccount(account);
        if (savedAccount == null) {
            // HTTP STATUS CODE 422
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).headers(headers).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(savedAccount);
    }

    @PostMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }

    private HttpHeaders defaultHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("company", "World Hosteling");
        headers.add("business-unit","Accounts");
        return  headers;
    }

}
