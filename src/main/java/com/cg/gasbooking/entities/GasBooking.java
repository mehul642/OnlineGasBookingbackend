package com.cg.gasbooking.entities;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;


@Entity
public class GasBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gasBookingId;
	private int customerId;
	private int cylinderId;
    private LocalDate bookingDate;
    private float bill;
	public GasBooking(int gasBookingId, int customerId,int cylinderId, LocalDate bookingDate, float bill) {
		super();
		this.gasBookingId = gasBookingId;
		this.customerId = customerId;
		this.cylinderId = cylinderId;
		this.bookingDate = bookingDate;
		this.bill = bill;
	}
	public GasBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGasBookingId() {
		return gasBookingId;
	}
	public void setGasBookingId(int gasBookingId) {
		this.gasBookingId = gasBookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCylinderId() {
		return cylinderId;
	}
	public void setCylinderId(int cylinderId) {
		this.cylinderId = cylinderId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "GasBooking [gasBookingId=" + gasBookingId + ", customerId=" + customerId + ",clinderId=" + cylinderId + ", bookingDate="
				+ bookingDate + ", bill=" + bill + "]";
	}
    

}
