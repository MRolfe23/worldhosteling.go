package com.worldhosteling.go.repositories;

import com.worldhosteling.go.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findAllByTo(Integer id);

    List<Post> findAllByFrom(Integer id);

    void deletePostById(Integer id);

}
