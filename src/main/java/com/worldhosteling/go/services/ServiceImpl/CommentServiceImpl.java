package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Comment;
import com.worldhosteling.go.repositories.CommentRepository;
import com.worldhosteling.go.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Comment findCommentById(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
