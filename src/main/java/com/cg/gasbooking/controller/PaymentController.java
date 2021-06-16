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

import com.cg.gasbooking.entities.Payment;
import com.cg.gasbooking.exception.PaymentBussinessException;
import com.cg.gasbooking.exception.PaymentControllerException;
import com.cg.gasbooking.service.PaymentService;



@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService iPaymentService;
	
	private Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping("/addpayment")
	public ResponseEntity<?> addPayment(@Valid @RequestBody Payment payment)
	
	{
		logger.info("******** Inserting Payment Details ********");
//		try {
		 Payment p=iPaymentService.addPayment(payment);
		 return  new ResponseEntity<Payment>(p,HttpStatus.OK);
//	}
//		catch(PaymentBussinessException e) {
//			PaymentControllerException c = new  PaymentControllerException(e.getErrormessage());
//			return new ResponseEntity<PaymentControllerException>(c,HttpStatus.BAD_REQUEST);
//		}
//		catch(Exception e) {
//			PaymentControllerException c = new  PaymentControllerException("Something Went Wrong");
//			return new ResponseEntity<PaymentControllerException>(c,HttpStatus.BAD_REQUEST);	
//		}	
	}
	
	@PutMapping("/updatepayment")
	public ResponseEntity<?> updatePayment(@Valid @RequestBody Payment payment)
	{
		logger.info("******** Updating Payment Details ********");
		try {
			 Payment p=iPaymentService.addPayment(payment);
			 return  new ResponseEntity<Payment>(p,HttpStatus.OK);
		}
			catch(PaymentBussinessException e) {
				PaymentControllerException c = new  PaymentControllerException(e.getErrormessage());
				return new ResponseEntity<PaymentControllerException>(c,HttpStatus.BAD_REQUEST);
			}
			catch(Exception e) {
				PaymentControllerException c = new  PaymentControllerException("Something Went Wrong");
				return new ResponseEntity<PaymentControllerException>(c,HttpStatus.BAD_REQUEST);	
			}
	}
	@DeleteMapping("/{paymentId}")
	public ResponseEntity<?> removePayment(@Valid @PathVariable("paymentId") Long id)
	{
		logger.info("******** Delete Payment Details ********");
		try {
			 iPaymentService.removePayment(id);
	        return  new ResponseEntity<Void>(HttpStatus.OK);
		}
			catch(PaymentBussinessException e) {
				PaymentControllerException c = new  PaymentControllerException(e.getErrormessage());
				return new ResponseEntity<PaymentControllerException>(c,HttpStatus.BAD_REQUEST);
			}
			catch(Exception e) {
				PaymentControllerException c = new  PaymentControllerException("Invalid PaymentId");
				return new ResponseEntity<PaymentControllerException>(c,HttpStatus.BAD_REQUEST);
			}
	}
	@GetMapping("/payments")
	@CrossOrigin
	public ResponseEntity<?> viewPayment() {
		logger.info("******** Get List of Payment ********");
		try {
			List<Payment> p = iPaymentService.getAllPaymentDetails();
			ResponseEntity<List<Payment>> rentity = new ResponseEntity<List<Payment>>(p, HttpStatus.OK);
			return rentity;
		} catch (PaymentBussinessException e) {
			PaymentControllerException c = new PaymentControllerException(e.getErrormessage());
			return new ResponseEntity<PaymentControllerException>(c, HttpStatus.BAD_REQUEST);
		}
	}
	// get one customer
	@CrossOrigin
		@GetMapping("/payment/{paymentId}")
		public ResponseEntity<?> getPayment(@Valid @PathVariable Long paymentId) {
			logger.info("******** Getting Payment by Id ********");
			try {
				Payment p = iPaymentService.getPayment(paymentId);
				ResponseEntity<Payment> rentity = new ResponseEntity<Payment>(p, HttpStatus.OK);
				return rentity;
			} catch (PaymentBussinessException e) {
				PaymentControllerException c = new PaymentControllerException(e.getErrormessage());
				return new ResponseEntity<PaymentControllerException>(c, HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				PaymentControllerException c = new PaymentControllerException("Something went wrong in Controller");
				return new ResponseEntity<PaymentControllerException>(c, HttpStatus.BAD_REQUEST);
			}
		}
	

}
