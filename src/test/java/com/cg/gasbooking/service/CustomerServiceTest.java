package com.cg.gasbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.gasbooking.entities.Customer;
import com.cg.gasbooking.repositories.ICustomerRepository;



@SpringBootTest
public class CustomerServiceTest
{

	@Autowired
	private CustomerServices cservice;

	@MockBean
	private ICustomerRepository customerDao;
	
	Customer c1;
	Customer c2;
	Customer c3;
	
	@BeforeEach
	public void init() {
		c1 = new Customer(0, "Kamal Dangi","Kamal@789","8209581610","kamal@gmail.com", null, null, null);
		c2 = new Customer(0, "Mehul Gupta","Mehul@123","9694779563","mehul@gmail.com", null, null, null);
		c3 = new Customer(0, "Archit Dixit","Archit@456","7894561230","archit@gmail.com", null, null, null);	
	}
	
	@Test
	public void testInsertCustomer() 
	{
		when(customerDao.save(c1)).thenReturn(c1);

		assertEquals(c1.getUsername(), cservice.insertCustomer(c1).getUsername());
		assertEquals(c1.getPassword(), cservice.insertCustomer(c1).getPassword());
		assertEquals(c1.getMobileNumber(), cservice.insertCustomer(c1).getMobileNumber());
		
		assertEquals(c1.getCustomerId(), cservice.insertCustomer(c1).getCustomerId());
		
	}
	
	@Test
	public void testUpdateCustomer() 
	{
		when(customerDao.existsById(c2.getCustomerId())).thenReturn(true);
		when(customerDao.save(c2)).thenReturn(c2);

		assertEquals(c2.getUsername(), cservice.updateCustomer(c2).getUsername());
		assertEquals(c2.getPassword(), cservice.updateCustomer(c2).getPassword());
		assertEquals(c2.getMobileNumber(), cservice.updateCustomer(c2).getMobileNumber());
		
		assertEquals(c2.getCustomerId(), cservice.updateCustomer(c2).getCustomerId());
		
	}
	
	@Test
	public void testDeleteCustomer()
	{
		when(customerDao.existsById(c3.getCustomerId())).thenReturn(true);
		customerDao.delete(c3);
		verify(customerDao, times(1)).delete(c3);
	}
	
	@Test
	public void testViewCustomers() 
	{
		List<Customer> allCustomers = new ArrayList<>();

		allCustomers.add(c1);
		allCustomers.add(c2);
		allCustomers.add(c3);

		when(customerDao.findAll()).thenReturn(allCustomers);
		assertEquals(3, cservice.viewCustomers().size());
	}
	
	
	@Test
	public void testViewCustomer()
	{
		when(customerDao.getOne(c1.getCustomerId())).thenReturn(c1);
		
		assertEquals(c1.getCustomerId(), cservice.viewCustomer(1).getCustomerId());
	}
}
