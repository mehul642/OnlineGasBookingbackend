package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class PaymentControllerException {
private String errormessage;
	
  public PaymentControllerException() {
	// TODO Auto-generated constructor stub
 
	
}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public PaymentControllerException(String errormessage) {
		super();
		this.errormessage = errormessage;
	}
	

}
