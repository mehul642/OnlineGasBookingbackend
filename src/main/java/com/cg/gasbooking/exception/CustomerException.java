package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomerException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CustomerException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	public CustomerException()
	{
		
	}
	@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
