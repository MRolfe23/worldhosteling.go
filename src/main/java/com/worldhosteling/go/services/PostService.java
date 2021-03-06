package com.worldhosteling.go.services;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post savePost(Post post);

    Optional<Post> findPostById(Integer id);

    List<Post> findAllPosts();

    List<Post> findAllPostByTo(Integer id);

    List<Post> findAllPostByFrom(Integer id);

    void deletePost(Integer id);

}
