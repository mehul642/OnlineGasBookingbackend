package com.cg.gasbooking.exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException
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
	
	
	public ControllerException(String errorMessage) 
	{
		super();
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() {
		return "ControllerException [errorMessage=" + errorMessage + "]";
	}
	public ControllerException()
	{
		
	}
	@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
