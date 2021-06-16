package com.cg.gasbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gasbooking.entities.Customer;
import com.cg.gasbooking.exception.ControllerException;
import com.cg.gasbooking.exception.CustomerException;
import com.cg.gasbooking.service.ICustomerServices;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
	@Autowired
	private ICustomerServices iCustomerServices;

	private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	// add customer
	@PostMapping("/insertcustomer")
	public ResponseEntity<?> insertCustomer(@Valid @RequestBody Customer customer)
	{
		logger.info("******** Inserting Customer Details ********");

		try {
			Customer c = iCustomerServices.insertCustomer(customer);
			return new ResponseEntity<String>("Customer With ID : " + c.getCustomerId() + " Created Successfully!",
					HttpStatus.CREATED);
		} catch (CustomerException e) {
			ControllerException ce = new ControllerException(e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("Something went wrong in Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	// update customer
	@PutMapping("/updatecustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {

		logger.info("******** Updating Customer ********");
		
		try {
			Customer c = iCustomerServices.updateCustomer(customer);
			ResponseEntity<String> rentity = new ResponseEntity<String>(
					"Customer With ID : " + c.getCustomerId() + " updated Successfully!", HttpStatus.OK);
			return rentity;
		} catch (CustomerException e) {
			ControllerException ce = new ControllerException(e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("Something went wrong in Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	// delete customer
	@DeleteMapping("/deletecustomer/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) {
		
		logger.info("******** Deleting Customer ********");
		
		try {
			Customer c = iCustomerServices.viewCustomer(customerId);
			iCustomerServices.deleteCustomer(c.getCustomerId());
			ResponseEntity<String> rentity = new ResponseEntity<String>(
					"Customer With Given ID : " + customerId + " Deleted Succesfully", HttpStatus.OK);
			return rentity;
		} catch (CustomerException e) {
			ControllerException ce = new ControllerException(e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("Something went wrong in Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	// get all customers
	@GetMapping("/customers")
	public ResponseEntity<?> viewCustomer() {
		logger.info("******** Get List of Customer ********");
		try {
			List<Customer> customers = iCustomerServices.viewCustomers();
			ResponseEntity<List<Customer>> rentity = new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
			return rentity;
		} catch (CustomerException e) {
			ControllerException ce = new ControllerException(e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	// get one customer
	@GetMapping("/getcustomer/{customerId}")
	public ResponseEntity<?> viewCustomer(@PathVariable int customerId) {
		logger.info("******** Getting Customer by Id ********");
		try {
			Customer customer = iCustomerServices.viewCustomer(customerId);
			ResponseEntity<Customer> rentity = new ResponseEntity<Customer>(customer, HttpStatus.OK);
			return rentity;
		} catch (CustomerException e) {
			ControllerException ce = new ControllerException(e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("Something went wrong in Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
}
