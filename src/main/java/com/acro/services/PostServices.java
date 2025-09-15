package com.acro.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.acro.entity.Post;
import com.acro.repository.CommentRepository;
import com.acro.repository.PostRepository;

@Service
public class PostServices {
	
	private final PostRepository postRepo;
    private final CommentRepository commentRepo;

    public PostServices(PostRepository postRepo, CommentRepository commentRepo) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    public Post createPost(String title, String content) {
        String id = UUID.randomUUID().toString();
        Post p = new Post(id, title, content, LocalDateTime.now());
        return postRepo.save(p);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post updatePost(String id, String title, String content) {
        Post existing = postRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
        if (title != null) existing.setTitle(title);
        if (content != null) existing.setContent(content);
        postRepo.save(existing);
        return existing;
    }

    public void deletePost(String id) {
        if (!postRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        // cascade delete comments for this post
        commentRepo.deleteByPostId(id);
        postRepo.deleteById(id);
    }

    public Post getPostById(String id) {
        return postRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
    }

}
