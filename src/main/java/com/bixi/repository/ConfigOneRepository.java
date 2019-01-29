package com.bixi.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bixi.data.domain.model.db.ConfigOne;

public interface ConfigOneRepository extends CrudRepository<ConfigOne,Long> {

	List<ConfigOne> findByKey(String key);
}
