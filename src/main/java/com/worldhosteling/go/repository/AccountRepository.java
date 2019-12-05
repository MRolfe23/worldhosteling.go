package com.worldhosteling.go.repository;

import com.worldhosteling.go.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {

    @Query("Select c from Account c where c.userName like %:username%")
    List<Account> findAllByUserName(String username);

    @Query("Select c from Account c where c.firstName like %:name% or c.lastName like %:name%")
    List<Account> findAllByFirstNameLikeOrLastNameLike(String name);

    @Query("Select c from Account c where c.email = email and c.password = password")
    Account findAccountByEmailEqualsAndPasswordEquals(String email, String password);

    void deleteById(String id);

    Account findByEmail(String email);
}
