# Blog Posts & Comments API

A simple Spring Boot REST API to manage blog posts and comments.  
Supports basic CRUD operations with cascade delete of comments when a post is removed.  
Data is stored **in-memory** (using `HashMap`/`ArrayList`), so all data resets on server restart.

---

## Features

- **Posts**
  - `POST /posts` → Create a new blog post
  - `GET /posts` → Retrieve all posts
  - `PUT /posts/{id}` → Update a post’s title or content
  - `DELETE /posts/{id}` → Remove a post and all its comments (cascade delete)

- **Comments**
  - `POST /posts/{id}/comments` → Add a comment to a post
  - `GET /posts/{id}/comments` → List comments for a post
  - `DELETE /comments/{id}` → Delete a specific comment

---

## Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- **Maven**
- In-memory storage (`HashMap`, `ArrayList`)

---

## Getting Started

### 1. Clone the repo
```bash
git clone https://github.com/your-username/blog-api.git
cd blog-api
