package com.acro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acro.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, String>  {

}
