package com.cg.gasbooking.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gasbooking.entities.SurrenderCylinder;
import com.cg.gasbooking.exception.SurrenderBusinessException;
import com.cg.gasbooking.exception.SurrenderControllerException;
import com.cg.gasbooking.service.ISurrenderCylinderService;

@RestController
@RequestMapping("/surrendercylinder")
@CrossOrigin
public class SurrenderController {

	@Autowired
	private ISurrenderCylinderService surrenderService;
	
	private Logger logger = LoggerFactory.getLogger (SurrenderController.class);

	@PostMapping("/insert")
	public ResponseEntity<?> insertSurrenderCylinder(@RequestBody SurrenderCylinder surrendercylinder) {
		
		logger.info("******** Inserting Surrender Cylider Details ********");
		
//		try {
			SurrenderCylinder sc = surrenderService.insertSurrenderCylinder(surrendercylinder);
			return new ResponseEntity<SurrenderCylinder>(sc, HttpStatus.ACCEPTED);
//	}catch(SurrenderBusinessException e) {
//		SurrenderControllerException ce  = new  SurrenderControllerException(e.getErrormessage());
//			return new ResponseEntity<SurrenderControllerException>(ce,HttpStatus.BAD_REQUEST);
//		}
//		catch(Exception e) {
//			SurrenderControllerException ce  = new  SurrenderControllerException("Something Went Wrong");
//				return new ResponseEntity<SurrenderControllerException>(ce,HttpStatus.BAD_REQUEST);
//		}
}
	@PutMapping("/update")
	public ResponseEntity<?> updateSurrenderCylinder(@RequestBody SurrenderCylinder surrenderCylinder) {
		
		logger.info("******** Update Surrender Cylider Details ********");
		
		try {
		SurrenderCylinder sc = surrenderService.updateSurrenderCylinder(surrenderCylinder);
		return new ResponseEntity<SurrenderCylinder>(sc, HttpStatus.ACCEPTED);
	}catch(SurrenderBusinessException e) {
		SurrenderControllerException ce  = new  SurrenderControllerException(e.getErrormessage());
			return new ResponseEntity<SurrenderControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
//		catch(Exception e) {
//			SurrenderControllerException ce  = new  SurrenderControllerException("Something Went Wrong");
//				return new ResponseEntity<SurrenderControllerException>(ce,HttpStatus.BAD_REQUEST);
//		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		
		logger.info("******** Delete Surrender Cylider Details By Id ********");
		
		try {
		surrenderService.deletById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}catch(Exception e) {
		SurrenderControllerException ce  = new  SurrenderControllerException("Invalid Admin Id");
			return new ResponseEntity<SurrenderControllerException>(ce,HttpStatus.BAD_REQUEST);
	}
}
	@GetMapping("/count")
	public int countSurrenderCylinder() {
		
		logger.info("******** Counting Surrender Cylider  ********");
		
		try {
	return surrenderService. countSurrenserCylinder();	
	}catch(Exception e) {
		throw new  NoSuchMessageException("empty List");   
	}	
}
	@GetMapping("/view")	
	public ResponseEntity<?> getSurrenderCylinder(){
		
		logger.info("******** Getting Surrender Cylider Details ********");
		
		try {
		 List<SurrenderCylinder> list = this.surrenderService.getSurrenderCylinder();
		 return new  ResponseEntity<List<SurrenderCylinder>>(list ,HttpStatus.OK);

	}catch(SurrenderBusinessException e) {
		  SurrenderControllerException ce  = new  SurrenderControllerException(e.getErrormessage());
			return new ResponseEntity<SurrenderControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			SurrenderControllerException ce  = new  SurrenderControllerException("Something Went Wrong");
				return new ResponseEntity<SurrenderControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
}
}