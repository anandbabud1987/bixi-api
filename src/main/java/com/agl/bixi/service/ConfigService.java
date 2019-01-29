package com.agl.bixi.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agl.bixi.model.config.ConfigReq;
import com.agl.bixi.model.config.ConfigRes;
import com.agl.bixi.rest.ConfigController;
import com.bixi.data.domain.model.db.ConfigOne;
import com.bixi.repository.ConfigOneRepository;

@Service
public class ConfigService<S> {
	public static final Logger logger = LoggerFactory.getLogger(ConfigService.class);
	@Autowired
	ConfigOneRepository mConfigOneRepository;
	public List<ConfigOne> getConfigOne(String key) {
		 return mConfigOneRepository.findByKey(key);
		
	}
	
	public ConfigRes saveConfigOne(ConfigReq configReq) {
		ConfigRes objConfigRes=new ConfigRes();
		if(validate(configReq)){
			mConfigOneRepository.save(new ConfigOne(configReq.getKey().toString(), configReq.getValue().toString(),
					configReq.getCode().toString(), new Date()));
			objConfigRes.setErrorCode(0);
			objConfigRes.setMessage("Successfully saved config");
		}
		return objConfigRes;
		
	}

	private boolean validate(ConfigReq configReq) {
		if(configReq==null) {
			return false;
		}
		return true;
	}

}
