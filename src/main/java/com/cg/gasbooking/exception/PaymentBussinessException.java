package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class PaymentBussinessException extends RuntimeException {

private String errormessage;
	
	public PaymentBussinessException() {
		
	}

	public PaymentBussinessException(String errormessage) {
		super();
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	

}


