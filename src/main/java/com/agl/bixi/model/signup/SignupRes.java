/**
 * 
 */
package com.agl.bixi.model.signup;
import java.io.Serializable;
/**
 * @author agl
 *
 */
public class SignupRes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer errorCode;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the errorCode
	 */
	public Integer getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
