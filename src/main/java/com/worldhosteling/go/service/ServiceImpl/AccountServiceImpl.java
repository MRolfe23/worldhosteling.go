package com.worldhosteling.go.service.ServiceImpl;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.repository.AccountRepository;
import com.worldhosteling.go.service.AccountService;
import org.springframework.stereotype.Service;

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

}
