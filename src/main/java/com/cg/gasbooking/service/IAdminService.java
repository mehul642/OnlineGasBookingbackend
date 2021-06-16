package com.cg.gasbooking.service;



import java.util.List;

import com.cg.gasbooking.entities.Admin;
import com.cg.gasbooking.entities.GasBooking;



public interface IAdminService {
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public void deleteById(int id);
	public List<Admin> getAdmin();
	
}
