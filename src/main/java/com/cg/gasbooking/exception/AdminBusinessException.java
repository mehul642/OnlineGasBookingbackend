package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component  
public class AdminBusinessException extends RuntimeException {
	
	private  String errormessage;

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public AdminBusinessException(String errormessage) {
		super();
		this.errormessage = errormessage;
	}

	public AdminBusinessException() {
		
	}

	@Override
	public String toString() {
		return "BusinessException [errormessage=" + errormessage + "]";
	}
	
	@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
