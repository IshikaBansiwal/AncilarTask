package com.acro.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {
	
       @Id	
		private String id;
		private String title;
		private String content;
		private int createdAt;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public int getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(int createdAt) {
			this.createdAt = createdAt;
		}
		@Override
		public String toString() {
			return "Post [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt + "]";
		}
		public Post(String id, String title, String content, int createdAt) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.createdAt = createdAt;
		}
		public Post() {
			super();
			
		}
		
		
		
		

	}


