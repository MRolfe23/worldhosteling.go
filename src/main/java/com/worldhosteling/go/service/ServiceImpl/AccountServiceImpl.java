package com.worldhosteling.go.service.ServiceImpl;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.repository.AccountRepository;
import com.worldhosteling.go.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Account> findAllAccountsWhereNameLike(String firstName, String lastName) {
        return accountRepository.findAllByFirstNameLikeOrLastNameLike(firstName, lastName);
    }

    @Override
    public List<Account> findAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }

}
