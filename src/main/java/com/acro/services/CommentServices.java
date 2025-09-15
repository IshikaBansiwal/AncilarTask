package com.acro.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.acro.entity.Comment;
import com.acro.entity.Post;
import com.acro.repository.CommentRepository;
import com.acro.repository.PostRepository;

@Service
public class CommentServices {
	private final CommentRepository commentRepo;
    private final PostRepository postRepo;

    public CommentServices(CommentRepository commentRepo, PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    public Comment addComment(String postId, String author, String text) {
        // validate post exists
        Post p = postRepo.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

        String id = UUID.randomUUID().toString();
        Comment c = new Comment(id, postId, author, text, LocalDateTime.now());
        return commentRepo.save(c);
    }

    public List<Comment> getCommentsForPost(String postId) {
        if (!postRepo.existsById(postId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        return commentRepo.findAllByPostId(postId);
    }

    public void deleteComment(String id) {
        if (!commentRepo.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
        }
        commentRepo.deleteById(id);
    }

}
