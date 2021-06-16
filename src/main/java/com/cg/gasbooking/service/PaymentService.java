package com.cg.gasbooking.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gasbooking.entities.Payment;
import com.cg.gasbooking.exception.PaymentBussinessException;
import com.cg.gasbooking.repositories.PaymentRepository;



@Service
public class PaymentService implements IPaymentService {
	
	private Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		
		logger.info("Called addPayment() method of PaymentService");

		return paymentRepository.save(payment);
	}

	@Override
	public Payment removePayment(long paymentId) throws PaymentBussinessException {
		logger.info("Called removePayment() method of PaymentService");

		Optional<Payment> searchedPayment = paymentRepository.findById(paymentId);
		if (searchedPayment.isPresent()) {
			Payment paymentToDelete = searchedPayment.get();
			paymentRepository.delete(paymentToDelete);
			return paymentToDelete;
		} else {
			throw new PaymentBussinessException("Payment you are trying to delete is not available");
		}

	}

	@Override
	public Payment updatePayment(long paymentId, Payment payment) throws PaymentBussinessException {
		logger.info("Called updatePayment() method of PaymentService");
		Optional<Payment> searchedPayment = paymentRepository.findById(paymentId);
		if (searchedPayment.isPresent()) {
			return paymentRepository.save(payment);
		} else {
			throw new PaymentBussinessException("Payment you are trying to update is not available");
		}

	}

	@Override
	public Payment getPayment(long paymentId) throws PaymentBussinessException {
		logger.info("Called getPayment() method of PaymentService");
		Optional<Payment> searchedPayment = paymentRepository.findById(paymentId);
		if (searchedPayment.isPresent()) {
			return searchedPayment.get();
		} else {
			throw new PaymentBussinessException("Payment you are trying to view is not available");
		}

	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		logger.info("Called getAllPaymentDetails() method of PaymentService");
		return paymentRepository.findAll();
	}


}
