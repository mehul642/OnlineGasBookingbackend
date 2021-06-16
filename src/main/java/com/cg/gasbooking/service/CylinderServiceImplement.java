package com.cg.gasbooking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.gasbooking.controller.CylinderController;
import com.cg.gasbooking.entities.Customer;
import com.cg.gasbooking.entities.Cylinder;
import com.cg.gasbooking.exception.CylinderBusinessException;
import com.cg.gasbooking.repositories.ICylinderRepository;

@Service
public class CylinderServiceImplement implements ICylinderService {

	@Autowired
	private ICylinderRepository cylinderDao;
	
	private Logger logger = LoggerFactory.getLogger(CylinderServiceImplement.class);
	
	@Override
	public List<Cylinder> viewCylinder() {
		// TODO Auto-generated method stub
		
			logger.info("******** Get Cylinder Details ********");
		
			List<Cylinder> listofcylinder = cylinderDao.findAll();
			if (listofcylinder.isEmpty()) {
				throw new CylinderBusinessException( "Hey List is empty, we do not have data in database");
			}
			try {
			return listofcylinder;
		} catch (Exception e) {
			throw new CylinderBusinessException( "Something went wrong :" + e.getMessage());
		}

	}

	@Override
	public Cylinder insertCylinder(Cylinder cylinder) {
		// TODO Auto-generated method stub
		
		
		logger.info("******** Inserting Cylinder Details ********");
		
		if (cylinder.getStrapColor().isEmpty() || cylinder.getType().isEmpty()|| 
				 cylinder.getPrice() ==0 || cylinder.getWeight() == 0) {
			
			throw new CylinderBusinessException( "Please Send Proper Details,Its blank");
		}
			
		try {
			
			Cylinder savecylinder = cylinderDao.save(cylinder);
			return savecylinder;
		} catch (IllegalArgumentException e) {
			throw new CylinderBusinessException( "Please give proper name of entity" + e.getMessage());
		} catch (Exception e) {
			throw new CylinderBusinessException( "Something went wrong : " + e.getMessage());
		}
	}

	@Override
	public Cylinder updateCylinder(Cylinder cylinder) {
		// TODO Auto-generated method stub
		logger.info("******** Update Cylinder Details ********");
		if(cylinder.getCylinderId()== 0 ||cylinder.getStrapColor().isEmpty()|| cylinder.getType().isEmpty()
				) {
			throw new CylinderBusinessException("Please Send Proper Details,Its blank or not matching");
		}
		try {
			cylinderDao.save(cylinder);	
			return cylinder;
		}catch (IllegalArgumentException e) {
			throw new CylinderBusinessException( "Please give proper name of entity" + e.getMessage());
	}catch (Exception e) {
		throw new CylinderBusinessException( "You can't change CylinderId" + e.getMessage());
	}
}
		
	@Override
	public Optional<Cylinder> getCylinder(String type) {
		// TODO Auto-generated method stub
		logger.info("******** Get Cylinder Details  By Cylinder Type  ********");
		return cylinderDao.findByType(type);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		logger.info("******** Get Cylinder Details  By Id ********");
		try {
			cylinderDao.deleteById(id);	
		}catch (IllegalArgumentException e) {
			throw new CylinderBusinessException( "Please give proper name id" + e.getMessage());
	}catch(Exception e) {
		throw new CylinderBusinessException("invalid Cylinder ID");
	}
}

	@Override
	public List<Cylinder> getCylinder() {
		// TODO Auto-generated method stub
		return cylinderDao.findAll();
	}

	@Override
	public Cylinder getCylinder(int id) {
		// TODO Auto-generated method stub
		return cylinderDao.getOne(id);
	}
}