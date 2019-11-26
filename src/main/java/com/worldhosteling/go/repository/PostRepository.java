package com.worldhosteling.go.repository;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findAllByTo(Account account);

    List<Post> findAllByFrom(Account account);

}
