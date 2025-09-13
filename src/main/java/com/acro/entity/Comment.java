package com.acro.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

	@Id
	private String id;
	private String postId;
	private String author;
	private String text;
	private int createdAt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", author=" + author + ", text=" + text + ", createdAt="
				+ createdAt + "]";
	}
	public Comment(String id, String postId, String author, String text, int createdAt) {
		super();
		this.id = id;
		this.postId = postId;
		this.author = author;
		this.text = text;
		this.createdAt = createdAt;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
		

	}

