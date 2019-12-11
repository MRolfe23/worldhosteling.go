package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.Comment;
import com.worldhosteling.go.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/")
    public List<Comment> getAllComments() {
        return commentService.findAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        Comment foundComment = commentService.findCommentById(id);

        if (foundComment == null) {
            logger.error("Comment with id: " + id + " was not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        logger.info("Comment found with id: " + id);
        return ResponseEntity.ok().body(foundComment);
    }

    @PostMapping("/")
    public Comment saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @PostMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
    }

}
