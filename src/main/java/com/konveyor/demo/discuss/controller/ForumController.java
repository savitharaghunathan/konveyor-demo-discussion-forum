package com.konveyor.demo.discuss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.konveyor.demo.discuss.model.CustomUserDetails;
import com.konveyor.demo.discuss.model.Forum;
import com.konveyor.demo.discuss.model.User;
import com.konveyor.demo.discuss.service.ForumService;

@Controller
public class ForumController {

	@Autowired
	ForumService forumService;
	
	@GetMapping("/getallforumposts")
	public String getAllForumPosts(Model model) {
		List<Forum> allPosts = forumService.getAllForumPosts();
		model.addAttribute("allPosts",allPosts);
		return "viewAllPosts";
	}
	@GetMapping("/getPostsbyUsername")
	public String getPostsbyUsername(@AuthenticationPrincipal CustomUserDetails userdetails,Model model) {
		String email = userdetails.getUsername();
		List<Forum> allPosts = forumService.getAllForumPostsByUser(email);
		model.addAttribute("allPosts",allPosts);
		return "viewUserPosts";
	}
	
	// 
	@RequestMapping(path="/addforumpost", method= RequestMethod.POST)
    public String addForumPost(@AuthenticationPrincipal CustomUserDetails userdetails,Forum forum){
         forumService.addForumPost(userdetails,forum);
         return "post_success";
    }
	
	@GetMapping("/addpost")
	public String showRegistrationForm(Model model) {
		model.addAttribute("forum", new Forum());
		
		return "addForumPost";
	}
	
}
