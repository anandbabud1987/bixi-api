/**
 * 
 */
package com.agl.bixi.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agl.bixi.model.LoginModel;

/**
 * @author agl
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping(value = "/user", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<LoginModel> getUserDetail(){
		logger.info("getUserDetail started.");
		LoginModel loginModel=new LoginModel("anand","babu");
		logger.info("getUserDetail ended.");
		return new ResponseEntity<LoginModel>(loginModel, HttpStatus.OK);
	}
	@RequestMapping(value = "/checkuser", method = RequestMethod.POST,produces="application/json")
	public ResponseEntity<LoginModel> checkUser(@RequestBody LoginModel loginmodel){
		logger.info("checkUser started.");
		LoginModel res=null;
		if(loginmodel!=null) {
			res=new LoginModel();
			res.setLoginSuccess(loginmodel.getUsername().equals("anand"));
		}
		logger.info("checkUser ended.");
		return new ResponseEntity<LoginModel>(res, HttpStatus.OK);
	}

}
