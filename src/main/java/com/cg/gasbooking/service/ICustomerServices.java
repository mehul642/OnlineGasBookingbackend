package com.cg.gasbooking.service;

import java.util.List;

import com.cg.gasbooking.entities.Customer;



public interface ICustomerServices 
{
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId);
	public List<Customer> getCostomers();
	
	
}
