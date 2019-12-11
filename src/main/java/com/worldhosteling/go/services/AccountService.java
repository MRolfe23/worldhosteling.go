package com.worldhosteling.go.services;

import com.worldhosteling.go.models.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {

    Account saveAccount(Account account);

    Account findAccountById(String id);

    List<Account> findAccountByUserName(String username);

    List<Account> findAllAccountsWhereNameLike(String name);

    List<Account> findAllAccounts();

    Account findAccountByEmail(String email);

    Account verifyAccountCredentials(String email, String password);

    void deleteAccount(String id);

}
