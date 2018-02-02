package com.bixi.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserProfileRepository extends CrudRepository<com.bixi.data.domain.model.db.UserProfile, Serializable>{
	
	

}
