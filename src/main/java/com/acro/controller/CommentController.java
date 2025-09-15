package com.acro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acro.entity.Comment;
import com.acro.services.CommentServices;

@RestController
public class CommentController {

	 private final CommentServices commentService;

	    public static record CreateCommentRequest(String author, String text) {}

	    public CommentController(CommentServices commentService) {
	        this.commentService = commentService;
	    }

	    // POST /posts/{id}/comments : add comment to a post
	    @PostMapping("/posts/{id}/comments")
	    public ResponseEntity<Comment> addComment(@PathVariable("id") String postId, @RequestBody CreateCommentRequest req) {
	        if (req.text() == null || req.text().isBlank()) {
	            return ResponseEntity.badRequest().build();
	        }
	        Comment created = commentService.addComment(postId, req.author(), req.text());
	        return ResponseEntity.status(HttpStatus.CREATED).body(created);
	    }

	    // GET /posts/{id}/comments : list comments for a post
	    @GetMapping("/posts/{id}/comments")
	    public List<Comment> listComments(@PathVariable("id") String postId) {
	        return commentService.getCommentsForPost(postId);
	    }

	    // DELETE /comments/{id} : delete a specific comment
	    @DeleteMapping("/comments/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deleteComment(@PathVariable String id) {
	        commentService.deleteComment(id);
	    }
}
