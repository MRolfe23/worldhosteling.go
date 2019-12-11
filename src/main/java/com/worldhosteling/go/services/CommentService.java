package com.worldhosteling.go.services;

import com.worldhosteling.go.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Comment saveComment(Comment comment);

    Comment findCommentById(Integer id);

    List<Comment> findAllComments();

    void deleteComment(Integer id);

}
