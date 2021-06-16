package com.cg.gasbooking.service;

import java.util.Optional;


import com.cg.gasbooking.entities.Customer;
import com.cg.gasbooking.exception.UserNotFoundException;



public interface IUserService1 {

//	User register(User user);
//
//	User update(User user);
//
//	User findById(Long id);

	Customer findByUsername(String username);


//	void deleteByUserId(Long userId);
	
	public boolean validateUser(String username,String password) throws UserNotFoundException;
	
	public boolean checkValidUser(String username, String password);

}
