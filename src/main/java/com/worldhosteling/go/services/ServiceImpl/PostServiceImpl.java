package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.models.Post;
import com.worldhosteling.go.repositories.PhotoRepository;
import com.worldhosteling.go.repositories.PostRepository;
import com.worldhosteling.go.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    PostServiceImpl(PostRepository postRepository, PhotoRepository photoRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> findPostById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public List<Post> findAllPostByTo(Integer id) {
        return postRepository.findAllByTo(id);
    }

    @Override
    public List<Post> findAllPostByFrom(Integer id) {
        return postRepository.findAllByFrom(id);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deletePostById(id);
    }
}
