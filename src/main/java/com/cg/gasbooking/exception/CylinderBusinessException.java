package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;



@Component
public class CylinderBusinessException  extends RuntimeException{
    
	
	private String errormessage;
	
	
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public CylinderBusinessException( String errormessage) {
		super();
	
		this.errormessage = errormessage;
	}
	
     public CylinderBusinessException () {
    	 
     }

}