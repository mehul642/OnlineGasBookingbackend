package com.cg.gasbooking.exception;

public class UserNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFound() {
		super();
	}
	
	public UserNotFound(String message) {
		super(message);
	}
}
