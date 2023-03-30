package com.konveyor.demo.discuss.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.konveyor.demo.discuss.model.CustomUserDetails;
import com.konveyor.demo.discuss.model.Forum;
import com.konveyor.demo.discuss.repository.ForumRepository;

@Service
public class ForumService {

	@Autowired
	ForumRepository forum;
	
	
	public List<Forum> getAllForumPosts(){
		return (List<Forum>) forum.findAll();
	}
	
	
	 public List<Forum> getAllForumPostsByUser(String email){
	        return forum.findByUserEmail(email);
	    }
	 

	    public Forum addForumPost(CustomUserDetails userdetails,Forum forumPost){
	   
	    	forumPost.setUserEmail(userdetails.getUsername());
	    	forumPost.setTimestamp(new Date(System.currentTimeMillis()));

	        System.out.println("Forum Post:" + forumPost);

	        return forum.save(forumPost);
	    }
}