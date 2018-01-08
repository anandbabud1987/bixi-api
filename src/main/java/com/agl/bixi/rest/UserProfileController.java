package com.agl.bixi.rest;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agl.bixi.model.UserProfile;
import com.bixi.repository.UserProfileRepository;

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

	@Autowired
	UserProfileRepository userprofilerepostiory;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	DataSource dataSource;
	public UserProfileController() {
		
	}
	public static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);
	@RequestMapping(method = RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<UserProfile> saveUserProfile(UserProfile userprofile) throws Exception{
		logger.info("saveUserProfile started.");
		try {
			com.bixi.data.domain.model.db.UserProfile objUserProfile=new com.bixi.data.domain.model.db.UserProfile();
			objUserProfile.setUsername(String.valueOf(userprofile.getUsername()));
			objUserProfile.setEmail(String.valueOf(userprofile.getEmail()));
			objUserProfile.setFirstname(String.valueOf(userprofile.getFirstName()));
			objUserProfile.setLastname(String.valueOf(userprofile.getLastName()));
			userprofilerepostiory.save(objUserProfile);
			logger.info("saveUserProfile ended.");
			userprofile.setErrorText("Successfully User profile added to the system");
			userprofile.setErrorCode(0);
		}
		catch(Exception exp) {
			userprofile.setErrorText("Failed to save User profile to the system");
			userprofile.setErrorCode(1);
			return new ResponseEntity<UserProfile>(userprofile, HttpStatus.OK);

		}
		return new ResponseEntity<UserProfile>(userprofile, HttpStatus.OK);
	}

}
