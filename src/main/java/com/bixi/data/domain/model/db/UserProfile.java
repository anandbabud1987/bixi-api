package com.bixi.data.domain.model.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USER_PROFILE",schema="bschema")
public class UserProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5328922164750449150L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="username")
	@NotNull
	private String username ;
	
	@Column(name="email")
	@NotNull
    private String email;
	
	@Column(name="first_name")
	private String firstname ;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="dob")
	private Date dob;
    
	@Column(name="phone")
	private Integer phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="created_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdon;
    
	@PrePersist
	protected void onCreate() {
		createdon = new Date();
	}
    

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}



	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}



	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}



	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}



	/**
	 * @return the phone
	 */
	public Integer getPhone() {
		return phone;
	}



	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * @return the createdon
	 */
	public Date getCreatedon() {
		return createdon;
	}



	/**
	 * @param createdon the createdon to set
	 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}



	public UserProfile() {
		
	}

}
