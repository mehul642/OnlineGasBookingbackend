package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class CylinderControllerException {

	
	 private String errormessage;
	 
	public CylinderControllerException( String errormessage) {
		super();
		
		this.errormessage = errormessage;
	}


	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	@Override
	public String toString() {
		return "ControllerException [ errormessage=" + errormessage + "]";
	}
	 
	 public CylinderControllerException () {
		 
	 }
}
