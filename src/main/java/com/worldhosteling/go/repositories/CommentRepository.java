package com.worldhosteling.go.repositories;

import com.worldhosteling.go.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    void delete(Comment id);

}
