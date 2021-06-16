package com.cg.gasbooking.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gasbooking.controller.GasBookingController;
import com.cg.gasbooking.entities.GasBooking;
import com.cg.gasbooking.exception.ServiceBookingException;
import com.cg.gasbooking.repositories.IGasBookingDao;


@Service
public class GasBookingServiceImplementation implements IGasBookingService {

	@Autowired
	private IGasBookingDao gasBookingDao;
	
	private Logger logger = LoggerFactory.getLogger (GasBookingServiceImplementation.class);
	
	@Override
	public GasBooking insertGasBooking(GasBooking gasBooking) {
		
		logger.info("******** Inserting GasBooking Details ********");
		
//		if(gasBooking.getGasBookingId()==0)
//			throw new ServiceBookingException("Gas Booking Id cannot be null or zero");
//		else if(gasBooking.getCustomerId()==0)
//			throw new ServiceBookingException("Customer Id cannot be null or zero");
//		else if(gasBooking.getBookingDate()==null)
//			throw new ServiceBookingException("Date cannot be null");
//		else if(gasBooking.getBill()==0.0f)
//			throw new ServiceBookingException("Bill amount cannot be null or zero");
//		try {
			return gasBookingDao.save(gasBooking);
//		}
//		catch(IllegalArgumentException e) {
//			throw new ServiceBookingException("Given data has null values" + e.getMessage());
//		}catch(Exception e) {
//			throw new ServiceBookingException("Something went wrong in service layer");
//		}
//			
			
	}

	@Override
	public GasBooking updateGasBooking(GasBooking gasBooking) {
		
		logger.info("******** Update GasBooking Details ********");
		
		try {
		return gasBookingDao.save(gasBooking);
	}catch(IllegalArgumentException e) {
		throw new ServiceBookingException("Given Gas Booking Id is null, Please check");
	}catch(java.util.NoSuchElementException e) {
		throw new ServiceBookingException("Given Gas Booking Id does not exist in Database"+e.getMessage());
	}
	}

	@Override
	public GasBooking deleteGasBooking(int gasBookingId) {
		
		logger.info("******** Delete Gasbooking Details by Id ********");
		
		try {
			GasBooking entity = gasBookingDao.getOne(gasBookingId);
			gasBookingDao.delete(entity);
			return entity;
		}catch(IllegalArgumentException e) {
			throw new ServiceBookingException("Given Gas Booking id is null, Please check");
		}
		catch(java.util.NoSuchElementException e) {
			throw new ServiceBookingException("Given Gas Booking Id does not exist in Database"+e.getMessage());
		}
		
		
	}
	
	
	@Override
	public Optional<GasBooking> getBill(int id) {
		logger.info("******** Get Gasbooking Bill Details by Id ********");
		try {
			 return gasBookingDao.findBycustomerId(id);
		}catch(IllegalArgumentException e) {
			throw new ServiceBookingException("Given Customer Id is null, Please check");
		}catch(java.util.NoSuchElementException e) {
			throw new ServiceBookingException("Given Customer Id does not exist in Database"+e.getMessage());
		}
		
	}

	@Override
	public List<GasBooking> getBooking() {
		// TODO Auto-generated method stub
		return gasBookingDao.findAll();
	}

	

	

	

	

	
	

}
