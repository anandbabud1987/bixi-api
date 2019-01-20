/**
 * 
 */
package com.agl.bixi.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agl.bixi.model.signup.SignupRes;
import com.agl.bixi.model.signup.SignupReq;


/**
 * @author agl
 *
 */
@RestController
//@RequestMapping("/login")
public class LoginController {
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	/**
	 * To signup
	 */
	@CrossOrigin(origins = "${cross.origin.url}")
	@RequestMapping(value = "/signup", method = RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<SignupRes> signup(@RequestBody SignupReq signupreq) {
		logger.info("Signup started");
		SignupRes mSignupRes=new SignupRes();
		mSignupRes.setErrorCode(0);
		mSignupRes.setMessage("Success");
		return new ResponseEntity<SignupRes>(mSignupRes, HttpStatus.ACCEPTED) ;
	}

}
