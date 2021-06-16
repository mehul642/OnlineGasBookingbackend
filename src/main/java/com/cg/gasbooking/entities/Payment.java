package com.cg.gasbooking.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;




@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long paymentId;

	@NotNull(message = "payment status cannot be null")
	private String status;

	@NotNull(message = "card name cannot be null")
	@Size(min = 2, max = 30, message = "please enter card name")
	private String cardName;

	@NotNull(message = "card number cannot be null")
	private String cardNumber;

	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	
	@NotNull(message = "cvv cannot be null")
	private int cvv;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Payment(Long paymentId, @NotNull(message = "payment status cannot be null") String status,
			@NotNull(message = "card name cannot be null") @Size(min = 2, max = 30, message = "please enter card name") String cardName,
			@NotNull(message = "card number cannot be null") String cardNumber, @Future LocalDate expiryDate,
			@NotNull(message = "cvv cannot be null") int cvv) {
		super();
		this.paymentId = paymentId;
		this.status = status;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", status=" + status + ", cardName=" + cardName + ", cardNumber="
				+ cardNumber + ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
	}
	
	



}
