package com.cg.gasbooking.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.gasbooking.entities.Cylinder;


import com.cg.gasbooking.exception.CylinderBusinessException;
import com.cg.gasbooking.exception.CylinderControllerException;
import com.cg.gasbooking.service.ICylinderService;



@RestController
@RequestMapping("/cylinder")
@CrossOrigin
public class CylinderController {

	
	@Autowired
	private ICylinderService cylinderservice;
	
	private Logger logger = LoggerFactory.getLogger(CylinderController.class);
	
	
	@PostMapping("/insert")
	public ResponseEntity<?>  insertCylinder(@RequestBody Cylinder cylinder) {
		
		logger.info("******** Inserting Cylinder ********");
		
		try {
	        Cylinder c=  cylinderservice.insertCylinder(cylinder);
	        return  new ResponseEntity<Cylinder>(c,HttpStatus.OK );
		}catch(CylinderBusinessException e ) {
			CylinderControllerException ce = new CylinderControllerException(e.getErrormessage());  
			return new ResponseEntity<CylinderControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			CylinderControllerException ce= new CylinderControllerException("Sothing went wrong");  
			return new ResponseEntity<CylinderControllerException>(ce,HttpStatus.BAD_REQUEST); 
		}
		
	} 
	
	
	@GetMapping("/view")
	public ResponseEntity<?> viewCylinder(){
		
		logger.info("******** Get Cylinder Details ********");
		
		try {
		List<Cylinder> listcylinder= cylinderservice.viewCylinder();	
		 return new ResponseEntity<List<Cylinder>>(listcylinder,HttpStatus.OK);
	}catch(CylinderBusinessException e) {
		CylinderControllerException c=new CylinderControllerException( e.getErrormessage());
		return new ResponseEntity<CylinderControllerException>(c,HttpStatus.BAD_REQUEST); 
	}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCylinder(@RequestBody Cylinder cylinder ){
		logger.info("******** Update Cylinder Details ********");
		try {
		Cylinder updatecylinder= cylinderservice.updateCylinder(cylinder);
		return new ResponseEntity<Cylinder>(updatecylinder,HttpStatus.OK);
	}catch(CylinderBusinessException e) {    
		
		CylinderControllerException ce=new CylinderControllerException(e.getErrormessage());
		return new ResponseEntity<CylinderControllerException>(ce,HttpStatus.BAD_REQUEST); 
	}catch(Exception e) {
		CylinderControllerException ce=new CylinderControllerException("Something went wrong");
		return new ResponseEntity<CylinderControllerException>(ce,HttpStatus.BAD_REQUEST);		
	}
	}
	
	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	@ResponseBody
	public  Optional<Cylinder> getCylinder(@PathVariable String type) {
		
		logger.info("******** Get Cylinder Details  By Cylinder Type  ********");
		
		Optional<Cylinder> cylinderlist= cylinderservice.getCylinder(type);
	         return  cylinderlist;
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteById(@PathVariable int id) {
		
		logger.info("******** Delete Cylinder Details  By Id ********");
		try {
		     cylinderservice.deleteById(id);
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}catch(CylinderBusinessException e) {
			CylinderControllerException ce=new CylinderControllerException(e.getErrormessage());  
					return new ResponseEntity<CylinderControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			CylinderControllerException ce=new CylinderControllerException("invalid CylinderId"); 
			return new ResponseEntity<CylinderControllerException>(ce,HttpStatus.BAD_REQUEST);
		}   
	}
	
	@GetMapping("/viewid")
	public Cylinder getCylinder(@PathVariable int id){
		return this.cylinderservice.getCylinder(id);
		
	}
	
	
}	


