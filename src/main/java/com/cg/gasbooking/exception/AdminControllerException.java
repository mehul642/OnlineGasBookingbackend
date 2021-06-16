package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class AdminControllerException extends RuntimeException  {
	
	private String errormessage;

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public AdminControllerException(String errormessage) {
		super();
		this.errormessage = errormessage;
	}

	
	@Override
	public String toString() {
		return "ControllerException [errormessage=" + errormessage + "]";
	}

	public AdminControllerException() {
		
	}
	@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
