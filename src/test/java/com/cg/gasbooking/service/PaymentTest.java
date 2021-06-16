package com.cg.gasbooking.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.gasbooking.entities.Payment;
import com.cg.gasbooking.exception.PaymentBussinessException;
import com.cg.gasbooking.repositories.PaymentRepository;
import com.cg.gasbooking.service.PaymentService;

@ExtendWith(MockitoExtension.class)
public class PaymentTest {
	
	@InjectMocks
	private PaymentService pService;
	
	@Mock
	private PaymentRepository pRepository;
	
	@Test
	public void test_AddPayment() {
		Payment p = new Payment(null, "Credit", "Successful", null, null, 0);

		when(pRepository.save(p)).thenReturn(p);

		assertEquals(p.getPaymentId(), pService.addPayment(p).getPaymentId());

	}

	@Test
	public void testPayment() {
		Payment p = new Payment(null, "Credit", "Successful", null, null, 0);

		assertThat(pRepository.findById((p).getPaymentId())).isNotEqualTo(p);

	}

	@Test
	public void test_removePayment() throws PaymentBussinessException {
		try {
			Mockito.when(pService.removePayment(1))
					.thenThrow(new PaymentBussinessException ("No PaymentId is found"));
		} catch (Exception e) {
			assertTrue(e instanceof PaymentBussinessException);
		}
	}

	@Test
	void test_getAllPayments() throws Exception {
		Payment p1 = new Payment(null, "Credit", "Successful", null, null, 0);
		Payment p2 = new Payment(null, "Debit", "fail", null, null, 0);
		List<Payment> paymentlist = new ArrayList<>();
		paymentlist.add(p1);
		paymentlist.add(p2);
		Mockito.when(pRepository.findAll()).thenReturn(paymentlist);
		List<Payment> result = pService.getAllPaymentDetails();
		assertEquals(2, result.size());
	}


	

	@Test
	void test_getPayment() throws PaymentBussinessException {
		try {
			Mockito.when(pService.getPayment(1L)).thenThrow(new PaymentBussinessException("not found"));
		} catch (Exception c1) {

			Assertions.assertTrue(c1 instanceof PaymentBussinessException);
		}

	}
	

	
	

}
