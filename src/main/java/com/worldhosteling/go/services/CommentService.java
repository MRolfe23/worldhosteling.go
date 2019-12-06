package com.worldhosteling.go.services;

import com.worldhosteling.go.models.Comment;

import java.util.Optional;

public interface CommentService {

    Comment saveComment(Comment comment);

    Optional<Comment> findCommentById(Integer id);

    void deleteComment(Comment comment);


}
