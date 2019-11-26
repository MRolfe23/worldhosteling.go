package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.Comment;

import java.util.Optional;

public interface CommentService {

    Comment saveComment(Comment comment);

    Optional<Comment> findCommentById(Integer id);

    void deleteComment(Comment comment);


}
