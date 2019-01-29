package com.agl.bixi.model.config;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
public class ConfigReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Max(value=100,message="Maximum value for key should be 100")
	private String key;
	private String value;
	private String code;
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
