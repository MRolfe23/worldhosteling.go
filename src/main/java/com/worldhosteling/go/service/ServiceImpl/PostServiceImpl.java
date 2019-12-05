package com.worldhosteling.go.service.ServiceImpl;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.domain.Post;
import com.worldhosteling.go.repository.PhotoRepository;
import com.worldhosteling.go.repository.PostRepository;
import com.worldhosteling.go.service.PostService;
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
        return null;
    }

    @Override
    public List<Post> findAllPostByTo(Account account) {
        return postRepository.findAllByTo(account);
    }

    @Override
    public List<Post> findAllPostByFrom(Account account) {
        return postRepository.findAllByFrom(account);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
    }
}
