package com.acro.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Comment {
    private String id;
    private String postId;
    private String author;
    private String text;
    private LocalDateTime createdAt;

    public Comment() {}

    public Comment(String id, String postId, String author, String text, LocalDateTime createdAt) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.text = text;
        this.createdAt = createdAt;
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}