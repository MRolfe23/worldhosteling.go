package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.repositories.AccountRepository;
import com.worldhosteling.go.services.AccountService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findAccountById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAccountByUserName(String username) {
        return accountRepository.findAllByUserName(username);
    }

    @Override
    public List<Account> findAllAccountsWhereNameLike(String name) {
        return accountRepository.findAllByFirstNameLikeOrLastNameLike(name);
    }

    @Override
    public List<Account> findAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account verifyAccountCredentials(String email, String password) {
        return accountRepository.findAccountByEmailEqualsAndPasswordEquals(email, password);
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account foundAccount = this.findAccountByEmail(s);
        return new User(foundAccount.getEmail(), foundAccount.getPassword(), new ArrayList<>());

    }
}
