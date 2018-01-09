package com.agl.bixi.rest;

<<<<<<< HEAD


import java.util.List;
=======
import java.sql.SQLException;
import java.util.Date;
>>>>>>> eb3c845e78b824a32dac4ee1ff877ae4279de1c4

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<UserProfile> saveUserProfile(@RequestBody UserProfile userprofile) throws Exception{
		logger.info("saveUserProfile started.");
		try {
			com.bixi.data.domain.model.db.UserProfile objUserProfile=new com.bixi.data.domain.model.db.UserProfile();
			Query query=entityManager.createNamedQuery("UserProfile.findByUsername");
			query.setParameter("username", String.valueOf(userprofile.getUsername()));
			logger.info("username:"+String.valueOf(userprofile.getUsername()));
			List<Object> output=query.getResultList();
			logger.debug("Size of userprofile"+output.size());
			if(output!=null && output.size()>0) {
				logger.debug("Size of userprofile"+output.size());
				objUserProfile.setEmail(String.valueOf(userprofile.getEmail()));
				objUserProfile.setFirstname(String.valueOf(userprofile.getFirstName()));
				objUserProfile.setLastname(String.valueOf(userprofile.getLastName()));
				objUserProfile.setAccessToken(String.valueOf(userprofile.getAccessToken()));
				userprofilerepostiory.save(objUserProfile);
			
				
			}
			else {
				logger.debug("User does not exist in platform hence saving user details");
				objUserProfile.setUsername(String.valueOf(userprofile.getUsername()));
				objUserProfile.setEmail(String.valueOf(userprofile.getEmail()));
				objUserProfile.setFirstname(String.valueOf(userprofile.getFirstName()));
				objUserProfile.setLastname(String.valueOf(userprofile.getLastName()));
				objUserProfile.setAccessToken(String.valueOf(userprofile.getAccessToken()));

				userprofilerepostiory.save(objUserProfile);
				
			}
			logger.info("saveUserProfile ended.");
			userprofile.setErrorText("Successfully User profile added/updated to the system");
			userprofile.setErrorCode(0);
		}
		catch(Exception exp) {
			userprofile.setErrorText("Failed to save User profile to the system");
			userprofile.setErrorCode(1);
			
			return new ResponseEntity<UserProfile>(userprofile, HttpStatus.OK);

		}
		finally {
			
		}
		return new ResponseEntity<UserProfile>(userprofile, HttpStatus.OK);
	}

}
