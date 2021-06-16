// package com.cg.gasbooking.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//
//public class AbstractUser 
//{
//	
//	@NotBlank(message = "Username Cannot be blank ")
//	@Size(min = 6 , max =12)
//	private String username;
//	
//	@NotBlank(message = "Password Cannot be blank ")
//	@Size(min = 6 , max =12)
//	private String password;
//	
//	@Pattern(regexp = "[7|8|9][\\d]{9}" , message = "Invalid Mobile Number")
//	private String mobileNumber;
//	
//	@Email(regexp = "[a-zA-Z0-9_.]*[@][a-z]*[.][a-z]{2,3}" , message = "Invalid Email")
//	private String email;
//	
//	
//	public AbstractUser() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public AbstractUser(String username, String password, String mobileNumber, String email) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.mobileNumber = mobileNumber;
//		this.email = email;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getMobileNumber() {
//		return mobileNumber;
//	}
//
//	public void setMobileNumber(String mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	
//
//	@Override
//	public String toString() {
//		return "AbstractUser [username=" + username + ", password=" + password + ", mobileNumber=" + mobileNumber
//				+ ", email=" + email + "]";
//	}
//	
//	
//
//}
