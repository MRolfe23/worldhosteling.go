package com.worldhosteling.go.repository;

import com.worldhosteling.go.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    void delete(Comment id);

}
