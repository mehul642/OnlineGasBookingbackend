package com.cg.gasbooking.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.gasbooking.entities.Admin;
import com.cg.gasbooking.exception.AdminBusinessException;
import com.cg.gasbooking.exception.AdminControllerException;
import com.cg.gasbooking.repositories.IAdminRepository;


@Service
public class AdminServiceImplement implements IAdminService {

	@Autowired
	private IAdminRepository iadminRepository;
	
	private Logger logger = LoggerFactory.getLogger(AdminServiceImplement.class);
	@Override
	public Admin insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		logger.info("******** Inserting Admin Details ********");
		
		if (admin.getAdminId() == 0 ||  admin.getPassword().isEmpty() || admin.getUsername().isEmpty()) {
			throw new AdminBusinessException("Please give proper details : Entity is Blank");
		}
		try {

			iadminRepository.save(admin);
			return admin;
		} catch (IllegalArgumentException e) {
			throw new AdminBusinessException("Please give proper name of entity : " + e.getMessage());
		} catch (Exception e) {
			throw new AdminBusinessException("Something went wong : " + e.getMessage());
		}

	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
		logger.info("******** Update Admin Details ********");
		
		if (admin.getAdminId() == 0 || admin.getPassword().isEmpty() || admin.getUsername().isEmpty()) {
			throw new AdminBusinessException("Please give proper details : Entity is Blank");
		}
		try {
			iadminRepository.save(admin);
			return admin;
		} catch (IllegalArgumentException e) {
			throw new AdminBusinessException("Please give Prper Entity,It is invalid : " + e.getMessage());
		} catch (Exception e) {
			throw new AdminBusinessException("Something went wong : " + e.getMessage());
		}
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		logger.info("******** Delete Admin Details ********");
		
		try {
			iadminRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new AdminBusinessException("Please give proper name id" + e.getMessage());
		} catch (Exception e) {
			throw new AdminBusinessException("invalid Admin ID");
		}
	}

	@Override
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		logger.info("******** Get Admin Details ********");
		
		List<Admin> list= iadminRepository.findAll();
		if(list.isEmpty()) {
			throw new AdminBusinessException( "Hey List is empty, we do not have data in database");
		}
		try {
			return list;
		}catch (Exception e) {
			throw new AdminBusinessException( "Something went wrong :" + e.getMessage());
		}
		
	}

}
