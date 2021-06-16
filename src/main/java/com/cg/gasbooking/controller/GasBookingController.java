package com.cg.gasbooking.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gasbooking.entities.GasBooking;
import com.cg.gasbooking.exception.ControllerBookingException;
import com.cg.gasbooking.exception.ServiceBookingException;
import com.cg.gasbooking.service.IGasBookingService;




@RestController
@RequestMapping("/gasbooking")
@CrossOrigin 
public class GasBookingController {

	@Autowired
	private IGasBookingService iGasBookingService;
	
	private Logger logger = LoggerFactory.getLogger (GasBookingController.class);
	
	@PostMapping("/insertbooking")
	public ResponseEntity<?> insertGasBooking(@RequestBody GasBooking gasBooking) {
		
		logger.info("******** Inserting GasBooking Details ********");
		
//		try {
			GasBooking gasBookingSaved = this.iGasBookingService.insertGasBooking(gasBooking);
			return new ResponseEntity<GasBooking>(gasBookingSaved, HttpStatus.CREATED);
//		}catch(ServiceBookingException e) {
//			ControllerBookingException ce = new ControllerBookingException(e.getErrorMessage());
//			return new ResponseEntity<ControllerBookingException>(ce,HttpStatus.BAD_REQUEST);
//		}catch(Exception e) {
//			ControllerBookingException ce = new ControllerBookingException("Something went wrong in Controller");
//			return new ResponseEntity<ControllerBookingException>(ce,HttpStatus.BAD_REQUEST);
//		}
		
	}
	
	@PutMapping("/updatebooking")
	public ResponseEntity<?> updateGasBooking(@RequestBody GasBooking gasBooking) {
		
		logger.info("******** Update GasBooking Details ********");
		
		try {
			GasBooking gasBookingUpdated = this.iGasBookingService.updateGasBooking(gasBooking);
			return new ResponseEntity<GasBooking>(gasBookingUpdated, HttpStatus.OK);
		}catch(ServiceBookingException e) {
			ControllerBookingException ce = new ControllerBookingException(e.getErrorMessage());
			return new ResponseEntity<ControllerBookingException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerBookingException ce = new ControllerBookingException("Something went wrong in Controller");
			return new ResponseEntity<ControllerBookingException>(ce,HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deletebooking/{gasBookingId}")
	public ResponseEntity<?> deleteGasBooking(@PathVariable String gasBookingId) {
		
		logger.info("******** Delete Gasbooking Details by Id ********");
		
		try {
			GasBooking gasBookingdeleted = this.iGasBookingService.deleteGasBooking(Integer.parseInt(gasBookingId));
			return new ResponseEntity<GasBooking>(gasBookingdeleted, HttpStatus.OK);
		}catch(ServiceBookingException e) {
			ControllerBookingException ce = new ControllerBookingException(e.getErrorMessage());
			return new ResponseEntity<ControllerBookingException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerBookingException ce = new ControllerBookingException("Something went wrong in Controller");
			return new ResponseEntity<ControllerBookingException>(ce,HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/viewbooking/{customerId}", method = RequestMethod.GET)
	@ResponseBody  
	public ResponseEntity<?> getBill(@PathVariable String customerId) {
		
		logger.info("******** Get Gasbooking Bill Details by Id ********");
		
		try {
			Optional<GasBooking> gasBookingRetrieved = this.iGasBookingService.getBill(Integer.parseInt(customerId));
			return new ResponseEntity<Optional<GasBooking>>(gasBookingRetrieved, HttpStatus.OK);
		}catch(ServiceBookingException e) {
			ControllerBookingException ce = new ControllerBookingException(e.getErrorMessage());
			return new ResponseEntity<ControllerBookingException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerBookingException ce = new ControllerBookingException("Something went wrong in Controller");
			return new ResponseEntity<ControllerBookingException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
