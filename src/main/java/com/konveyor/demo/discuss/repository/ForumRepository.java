package com.konveyor.demo.discuss.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.konveyor.demo.discuss.model.Forum;

public interface ForumRepository extends CrudRepository<Forum, Long> {

	public List<Forum> findByUserEmail(String email);

}
