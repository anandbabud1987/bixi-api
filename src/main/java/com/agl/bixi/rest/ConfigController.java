package com.agl.bixi.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agl.bixi.model.config.ConfigReq;
import com.agl.bixi.model.config.ConfigRes;
import com.agl.bixi.service.ConfigService;
import com.bixi.data.domain.model.db.ConfigOne;


@RestController
public class ConfigController {
	public static final Logger logger = LoggerFactory.getLogger(ConfigController.class);
	@Autowired
	ConfigService configService;
	@CrossOrigin(origins = "${cross.origin.url}")
	@RequestMapping(value = "/config/one", method = RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<ConfigRes> getConfigOne(@RequestBody ConfigReq configReq) {
		logger.info("getConfigOne started");
		ConfigRes mConfigRes=configService.saveConfigOne(configReq);
		return new ResponseEntity<ConfigRes>(mConfigRes, HttpStatus.ACCEPTED) ;
	} 
	
	@CrossOrigin(origins = "${cross.origin.url}")
	@RequestMapping(value = "/config/one/{key}", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<ConfigOne>> getConfigOne(@PathVariable("key") String key) {
		logger.info("getConfigOne started");
		List<ConfigOne> mConfigRes=configService.getConfigOne(key);
		return new ResponseEntity<List<ConfigOne>>(mConfigRes, HttpStatus.ACCEPTED) ;
	} 
}
