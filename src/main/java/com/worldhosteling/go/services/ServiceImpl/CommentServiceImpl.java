package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Comment;
import com.worldhosteling.go.repositories.CommentRepository;
import com.worldhosteling.go.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findCommentById(Integer id) {
        return commentRepository.findById(id);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
}
