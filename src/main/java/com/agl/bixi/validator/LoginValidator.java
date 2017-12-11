/**
 * 
 */
package com.agl.bixi.validator;

import com.agl.bixi.model.LoginModel;

/**
 * @author agl
 *
 */
public class LoginValidator {
	
	public String validate(LoginModel loginmodel) {
		
		if(loginmodel==null) {
			return "Request body cannot be empty";
		}
		if(loginmodel.getUsername()==null) {
			return "username is blank in request body";
		}
		return "";
		
	}

}
