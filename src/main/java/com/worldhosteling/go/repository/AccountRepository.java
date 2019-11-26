package com.worldhosteling.go.repository;

import com.worldhosteling.go.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {

    List<Account> findAllByUserName(String username);

    List<Account> findAllByFirstNameLikeOrLastNameLike(String firstName, String lastName);
}
