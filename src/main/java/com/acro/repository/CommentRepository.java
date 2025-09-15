package com.acro.repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.acro.entity.Comment;

@Repository
public class CommentRepository {
	// map from commentId -> Comment
    private final Map<String, Comment> comments = new ConcurrentHashMap<>();

    public Comment save(Comment c) {
        comments.put(c.getId(), c);
        return c;
    }

    public Optional<Comment> findById(String id) {
        return Optional.ofNullable(comments.get(id));
    }

    public List<Comment> findAllByPostId(String postId) {
        return comments.values().stream()
                .filter(c -> postId.equals(c.getPostId()))
                .sorted(Comparator.comparing(Comment::getCreatedAt))
                .collect(Collectors.toList());
    }

    public void deleteById(String id) {
        comments.remove(id);
    }

    public void deleteByPostId(String postId) {
        List<String> toRemove = comments.values().stream()
                .filter(c -> postId.equals(c.getPostId()))
                .map(Comment::getId)
                .collect(Collectors.toList());
        toRemove.forEach(comments::remove);
    }

}
