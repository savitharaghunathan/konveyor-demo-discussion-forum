package com.konveyor.demo.discuss.service;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.konveyor.demo.discuss.model.CustomUserDetails;
import com.konveyor.demo.discuss.model.Forum;
import com.konveyor.demo.discuss.repository.ForumRepository;

@Service
public class ForumService {

	@Autowired
	ForumRepository forum;
	
	@Cacheable(value  = "allforum")
	public List<Forum> getAllForumPosts(){
		return (List<Forum>) forum.findAll();
	}
	
	@Cacheable(value  = "allforum")
	 public List<Forum> getAllForumPostsByUser(String email){
	        return forum.findByUserEmail(email);
	    }
	
	  
	@Cacheable(value  = "allforum")
	    public Forum addForumPost(CustomUserDetails userdetails,Forum forumPost){
	   
	    	forumPost.setUserEmail(userdetails.getUsername());
	    	forumPost.setTimestamp(new Date(System.currentTimeMillis()));

	        System.out.println("Forum Post:" + forumPost);

	        return forum.save(forumPost);
	    }
}