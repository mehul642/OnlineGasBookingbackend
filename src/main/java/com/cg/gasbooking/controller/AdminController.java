package com.cg.gasbooking.controller;

import java.util.List;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.gasbooking.entities.Admin;
import com.cg.gasbooking.entities.Customer;
import com.cg.gasbooking.entities.Cylinder;
import com.cg.gasbooking.entities.GasBooking;
import com.cg.gasbooking.exception.AdminBusinessException;
import com.cg.gasbooking.exception.AdminControllerException;
import com.cg.gasbooking.service.CustomerServices;
import com.cg.gasbooking.service.IAdminService;
import com.cg.gasbooking.service.ICylinderService;
import com.cg.gasbooking.service.IGasBookingService;


@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired 
	private IGasBookingService gasService;
	
	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private ICylinderService cylinderServices;

	private Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping("/insert")
	public ResponseEntity<?> insertAdmin(@Valid @RequestBody Admin admin) {

		logger.info("******** Inserting Admin Details ********");

		try {

			Admin ad = adminService.insertAdmin(admin);
			return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);
		} catch (AdminBusinessException e) {
			AdminControllerException ce = new AdminControllerException(e.getErrormessage());
			return new ResponseEntity<AdminControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			AdminControllerException ce = new AdminControllerException("Something Went Wrong");
			return new ResponseEntity<AdminControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateAdmin(@RequestBody Admin admin) {

		logger.info("******** Update Admin Details ********");

		try {
			Admin ad = adminService.updateAdmin(admin);
			return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);
		} catch (AdminBusinessException e) {
			AdminControllerException ce = new AdminControllerException(e.getErrormessage());
			return new ResponseEntity<AdminControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			AdminControllerException ce = new AdminControllerException("Something Went Wrong");
			return new ResponseEntity<AdminControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view")
	public ResponseEntity<?> getAdmin() {

		logger.info("******** Get Admin Details ********");

		try {

			List<Admin> listadmin = this.adminService.getAdmin();
			return new ResponseEntity<List<Admin>>(listadmin, HttpStatus.OK);
		} catch (AdminBusinessException e) {
			AdminControllerException ce = new AdminControllerException(e.getErrormessage());
			return new ResponseEntity<AdminControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			AdminControllerException ce = new AdminControllerException("Something Went Wrong");
			return new ResponseEntity<AdminControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		logger.info("******** Delete Admin Details ********");
		try {
			adminService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			AdminControllerException ce = new AdminControllerException("Invalid Admin Id");
			return new ResponseEntity<AdminControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewgas")
	public List<GasBooking> getBooking(){
	  return	this.gasService.getBooking();
	}
	
	@GetMapping("/viewcustomers")
	public List<Customer> getCustomer(){
		return this.customerServices.getCostomers();
	}
	
	@GetMapping("/viewcylinder")
	public List<Cylinder> getCylinder(){
		return this.cylinderServices.getCylinder();
	}
	

}
