package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class ServiceBookingException extends RuntimeException {
	/**
	 * 
	 */
	private String errorMessage;
	private static final long serialVersionUID = 1L;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ServiceBookingException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	public ServiceBookingException() {
		super();
	}
	 @Override
	    public synchronized Throwable fillInStackTrace() {
	        return this;
	    }
	
	
	

}
