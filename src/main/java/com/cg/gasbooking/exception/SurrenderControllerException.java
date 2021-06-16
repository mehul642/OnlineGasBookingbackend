package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class SurrenderControllerException {
	
    private String errormessage;

	public SurrenderControllerException(String errormessage) {
		super();
		this.errormessage = errormessage;
	}

	public SurrenderControllerException() {
		
		// TODO Auto-generated constructor stub
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	@Override
	public String toString() {
		return "ControllerException [errormessage=" + errormessage + "]";
	}
    
    
}
