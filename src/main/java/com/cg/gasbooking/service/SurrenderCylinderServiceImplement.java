package com.cg.gasbooking.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.gasbooking.entities.SurrenderCylinder;
import com.cg.gasbooking.exception.SurrenderBusinessException;
import com.cg.gasbooking.repositories.ISurrenderCylinderRepository;

@Service
public class SurrenderCylinderServiceImplement implements ISurrenderCylinderService {

	@Autowired
	private ISurrenderCylinderRepository surrenderRepository;
	
	private Logger logger = LoggerFactory.getLogger (SurrenderCylinderServiceImplement.class);
	@Override
	public SurrenderCylinder insertSurrenderCylinder(SurrenderCylinder surrenderCylinder) {
		// TODO Auto-generated method stub
		
		logger.info("******** Inserting Surrender Cylider Details ********");
		
//		if ( surrenderCylinder.getSurrenderDate().isEqual(null)) {
//			throw new SurrenderBusinessException(" Please Enter Proper Entities , it is empty");
//		}
//		try {
			surrenderRepository.save(surrenderCylinder);
			return surrenderCylinder;
//		} catch (IllegalArgumentException e) {
//			throw new SurrenderBusinessException("Please give proper name of entity" + e.getMessage());
//	} 
//			catch (Exception e) {
//			throw new SurrenderBusinessException("Something went wrong : " + e.getMessage());
//		}
	}

	@Override
	public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder surrenderCylinder) {
		// TODO Auto-generated method stub
		
		logger.info("******** Update Surrender Cylider Details ********");
		
//		if (surrenderCylinder.getSurrenderDate().isEqual(null)) {
//			throw new SurrenderBusinessException(" Please Enter Proper Entities , it is empty");
//		}
//		try {
			surrenderRepository.save(surrenderCylinder);
			return surrenderCylinder;
//		} catch (IllegalArgumentException e) {
//			throw new SurrenderBusinessException("Please give proper name of entity" + e.getMessage());
//		} 
//		catch (Exception e) {
//			throw new SurrenderBusinessException("You can't change CylinderId" + e.getMessage());
//		}
	}

	@Override
	public List<SurrenderCylinder> getSurrenderCylinder() {
		// TODO Auto-generated method stub
		
		logger.info("******** Get Surrender Cylider Details By Id ********");
		
		List<SurrenderCylinder> list = surrenderRepository.findAll();
		if (list.isEmpty()) {
			throw new SurrenderBusinessException("Hey List is empty, we do not have data in database");
		}
		try {
			return list;
		} catch (Exception e) {
			throw new SurrenderBusinessException("Something went wrong :" + e.getMessage());
		}
	}

	@Override
	public int countSurrenserCylinder() {
		// TODO Auto-generated method stub
		logger.info("******** Counting Surrender Cylider  ********");
		try {
			return (int) this.surrenderRepository.count();
		} catch (Exception e) {
			throw new SurrenderBusinessException("Something went wrong");
		}
	}

	@Override
	public void deletById(int id) {
		// TODO Auto-generated method stub
		logger.info("******** Delete Surrender Cylider Details By Id ********");
		try {
			surrenderRepository.deleteById(id);
		} catch (Exception e) {
			throw new SurrenderBusinessException("invalid Cylinder ID");
		}
	}
}