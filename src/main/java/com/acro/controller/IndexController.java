package com.acro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acro.entity.Post;
import com.acro.repository.PostRepo;
import com.acro.services.PostServices;

@Controller
public class IndexController {

	@Autowired
	PostRepo prepo;
	
	@Autowired
	PostServices pserv;

		
	@PostMapping
    public Post createPost(@RequestBody Post post) {
        return PostRepo.save(post);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return PostRepo.findAll();
    }
 
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post updated) {
        return PostRepo.findById(id).map(p -> {
            p.setTitle(updated.getTitle());
            p.setContent(updated.getContent());
            return postRepo.save(p);
        }).orElseThrow(() -> new RuntimeException("Post not found"));
    }

 
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable String id) {
        PostRepo.deleteById(id);
        return "Post deleted";
    }

    
    
};
	

