/**
 * 
 */
package com.bixi.data.domain.model.db;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author agl
 *
 */
@Entity
@Table(name="CONFIG_1")
public class ConfigOne implements Serializable{
	
	public ConfigOne(String key,String value,String code,java.util.Date date) {
		this.key=key;
		this.value=value;
		this.code=code;
		this.updateTimestamp=date;
	}
	
	public ConfigOne() {
		
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="id")
	 private Long  id; 
	 @Column(name="key")
	 private String key;
	 @Column(name="value")
	 private String value;
	 @Column(name="code")
	 private String code;
	 @Column(name="updated_timestamp")
	 private java.util.Date updateTimestamp;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
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
	/**
	 * @return the updateTimestamp
	 */
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	/**
	 * @param updateTimestamp the updateTimestamp to set
	 */
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}


}
