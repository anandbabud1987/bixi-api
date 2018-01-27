package com.bixi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bixi.data.domain.model.db.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}
