package com.cg.gasbooking.service;

import java.util.List;

import com.cg.gasbooking.entities.Payment;





public interface IPaymentService {

	public Payment addPayment(Payment payment);

	public Payment removePayment(long paymentid);

	public Payment updatePayment(long paymentid, Payment payment); 

	public Payment getPayment(long paymentId) ;

	public List<Payment> getAllPaymentDetails();
}
