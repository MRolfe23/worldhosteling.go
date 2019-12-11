package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.Post;
import com.worldhosteling.go.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/from/{id}")
    public List<Post> findAllPostsFromThisAccount(@PathVariable Integer id) {
        return postService.findAllPostByFrom(id);
    }

    @GetMapping("/to/{id}")
    public List<Post> findAllPostsToThisAccount(@PathVariable Integer id) {
        return postService.findAllPostByTo(id);
    }

    @PostMapping("/")
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @PostMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }

}
