package com.acro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.acro.entity.Post;
import com.acro.services.PostServices;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostServices postService;

    public static record CreatePostRequest(String title, String content) {}
    public static record UpdatePostRequest(String title, String content) {}

    public PostController(PostServices postService) {
        this.postService = postService;
    }

    // POST /posts : create a new post
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody CreatePostRequest req) {
        if (req.title() == null || req.title().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Post created = postService.createPost(req.title(), req.content());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // GET /posts : get all posts
    @GetMapping
    public List<Post> getAll() {
        return postService.getAllPosts();
    }

    // PUT /posts/{id} : update title/content
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody UpdatePostRequest req) {
        return postService.updatePost(id, req.title(), req.content());
    }

    // DELETE /posts/{id} : delete post + cascade comments
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable String id) {
        postService.deletePost(id);
    }
}
	

