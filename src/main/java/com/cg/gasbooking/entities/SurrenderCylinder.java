package com.cg.gasbooking.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
@Entity
public class SurrenderCylinder {
	@Id
	@NotNull(message ="Surrender Id cannot be null ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int surrenderId;
	private LocalDate surrenderDate;
	private String firstname;
	private String lastname;
	private int customerid;
	
	
	public SurrenderCylinder(@NotNull(message = "Surrender Id cannot be null ") int surrenderId,
			LocalDate surrenderDate, String firstname, String lastname, int customerid) {
		super();
		this.surrenderId = surrenderId;
		this.surrenderDate = surrenderDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.customerid = customerid;
	}


	public SurrenderCylinder() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getSurrenderId() {
		return surrenderId;
	}


	public void setSurrenderId(int surrenderId) {
		this.surrenderId = surrenderId;
	}


	public LocalDate getSurrenderDate() {
		return surrenderDate;
	}


	public void setSurrenderDate(LocalDate surrenderDate) {
		this.surrenderDate = surrenderDate;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	@Override
	public String toString() {
		return "SurrenderCylinder [surrenderId=" + surrenderId + ", surrenderDate=" + surrenderDate + ", firstname="
				+ firstname + ", lastname=" + lastname + ", customerid=" + customerid + "]";
	}
    
	
}