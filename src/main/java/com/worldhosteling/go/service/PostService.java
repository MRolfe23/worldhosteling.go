package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post savePost(Post post);

    Optional<Post> findPostById(Integer id);

    List<Post> findAllPosts();

    List<Post> findAllPostByTo(Account account);

    List<Post> findAllPostByFrom(Account account);

    void deletePost(Post post);

}
