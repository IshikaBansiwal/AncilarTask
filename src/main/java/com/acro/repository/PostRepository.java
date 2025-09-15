package com.acro.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.acro.entity.Post;

@Repository
public class PostRepository {

	// map from postId -> Post
    private final Map<String, Post> posts = new ConcurrentHashMap<>();

    public Post save(Post post) {
        posts.put(post.getId(), post);
        return post;
    }

    public Optional<Post> findById(String id) {
        return Optional.ofNullable(posts.get(id));
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public void deleteById(String id) {
        posts.remove(id);
    }

    public boolean existsById(String id) {
        return posts.containsKey(id);
    }

}
