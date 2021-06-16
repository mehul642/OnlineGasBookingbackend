package com.cg.gasbooking.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id

	@NotNull(message = "Admin Id cannot be null")
	private int adminId =1 ;

	private String FirstName ="Mehul";

	private String LastName = "Gupta";

	@NotBlank(message = "Username Cannot be blank ")
	@Size(min = 5, max = 12)
	private String username ="admin";

	@NotBlank(message = "Password Cannot be blank ")
	@Size(min = 5, max = 12)
	private String password ="admin";
	
	private boolean active = true;

	

	public Admin(@NotNull(message = "Admin Id cannot be null") int adminId, String firstName, String lastName,
			@NotBlank(message = "Username Cannot be blank ") @Size(min = 5, max = 12) String username,
			@NotBlank(message = "Password Cannot be blank ") @Size(min = 5, max = 12) String password, boolean active) {
		super();
		this.adminId = adminId;
		FirstName = firstName;
		LastName = lastName;
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", username="
				+ username + ", password=" + password + "]";
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	


}
