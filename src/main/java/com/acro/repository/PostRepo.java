package com.acro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acro.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
