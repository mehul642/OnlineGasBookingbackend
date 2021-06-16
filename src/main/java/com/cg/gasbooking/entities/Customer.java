package com.cg.gasbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity 
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	private String FirstName;
	
	private String LastName;
	
	private String Address;
	@NotBlank(message = "Username Cannot be blank ")
	@Size(min = 6 , max =12)
	private String username;
	
	@NotBlank(message = "Password Cannot be blank ")
	@Size(min = 6 , max =12)
	private String password;
	
	@Pattern(regexp = "[7|8|9][\\d]{9}" , message = "Invalid Mobile Number")
	private String mobileNumber;
	
	@Email(regexp = "[a-zA-Z0-9_.]*[@][a-z]*[.][a-z]{2,3}" , message = "Invalid Email")
	private String email;

	private boolean active = true;
	
	public Customer(int customerId, String firstName, String lastName, String address,
			@NotBlank(message = "Username Cannot be blank ") @Size(min = 6, max = 12) String username,
			@NotBlank(message = "Password Cannot be blank ") @Size(min = 6, max = 12) String password,
			@Pattern(regexp = "[7|8|9][\\d]{9}", message = "Invalid Mobile Number") String mobileNumber,
			@Email(regexp = "[a-zA-Z0-9_.]*[@][a-z]*[.][a-z]{2,3}", message = "Invalid Email") String email) {
		super();
		this.customerId = customerId;
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Address=" + Address + ", username=" + username + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", email=" + email + "]";
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	
}
