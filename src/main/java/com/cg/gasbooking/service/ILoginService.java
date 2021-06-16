package com.cg.gasbooking.service;


import com.cg.gasbooking.exception.LoginException;
import com.cg.gasbooking.exception.UserNotFoundException;


public interface ILoginService {
	
	public boolean login(String username, String password)throws LoginException, UserNotFoundException;

}
