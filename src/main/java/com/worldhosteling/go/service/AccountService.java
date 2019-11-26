package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account saveAccount(Account account);

    Optional<Account> findAccountById(String id);

    List<Account> findAccountByUserName(String username);

    List<Account> findAllAccountsWhereNameLike(String firstName, String lastName);

    List<Account> findAllAccounts();

    void deleteAccount(Account account);

}
