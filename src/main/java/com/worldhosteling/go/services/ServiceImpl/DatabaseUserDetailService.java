package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Account account = accountService.verif
        return null;
    }
}
