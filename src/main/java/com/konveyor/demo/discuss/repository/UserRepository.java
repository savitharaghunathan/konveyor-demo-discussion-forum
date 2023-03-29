package com.konveyor.demo.discuss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.konveyor.demo.discuss.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);
	
}