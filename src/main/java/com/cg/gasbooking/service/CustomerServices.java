package com.cg.gasbooking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gasbooking.controller.CustomerController;
import com.cg.gasbooking.entities.Customer;
import com.cg.gasbooking.exception.CustomerException;
import com.cg.gasbooking.repositories.ICustomerRepository;

@Service
public class CustomerServices implements ICustomerServices
{
	@Autowired
	private ICustomerRepository customerDao;

	private Logger logger = LoggerFactory.getLogger(CustomerServices.class);
	@Override
	public Customer insertCustomer(Customer customer)
	{
		logger.info("******** Inserting Customer Details ********");
		
//		if(customer.getFirstName().isEmpty() )
//		{
//			throw new CustomerException("Please Send Proper Details, Its Blank ");
//		}
//		try 
//		{
			customerDao.save(customer);
			return customer;
//		}
//		catch(IllegalArgumentException e)
//		{
//			throw new CustomerException("Please give proper name of entity" +e.getMessage());		
//		}
//		catch(Exception e)
//		{
//			throw new CustomerException("Something went wrong : " +e.getMessage());
//		}	
	}

	@Override
	public Customer updateCustomer(Customer customer)
	{
		logger.info("******** Updating Customer ********");
//		
//		if ( customer.getCustomerId() == 0 || 
//				 customer.getEmail().isEmpty() ||  customer.getMobileNumber().isEmpty() || 
//				  customer.getUsername().isEmpty() || customer.getPassword().isEmpty() )
//		{
//			throw new CustomerException("Please Send Proper Details, Its Blank ");
//		}
//		try 
//		{
			customerDao.save(customer);
			return customer;
//		}
//		catch(IllegalArgumentException e)
//		{
//			throw new CustomerException("Please give proper name of entity" +e.getMessage());		
//		}
//		catch(Exception e)
//		{
//			throw new CustomerException("Something went wrong : " +e.getMessage());
//		}
	}

	@Override
	public void deleteCustomer(int customerId) 	
	{
		logger.info("******** Deleting Customer ********");
		
		try 
		{

			customerDao.deleteById(customerId);
		}
		catch (IllegalArgumentException e) 
		{
			throw new CustomerException( "Please give proper name id" + e.getMessage());
		}
		catch(Exception e) 
		{
			throw new CustomerException("invalid Cylinder ID");
		}
    }
	
	@Override
	public List<Customer> viewCustomers()
	{
		logger.info("******** Get List of Customer ********");
		
		try
		{
			List<Customer> cusList= customerDao.findAll();
			if(cusList.isEmpty())
				throw new CustomerException("List is empty");
			return cusList;
		}
		catch (Exception e)
		{
			throw new CustomerException("Exception list empty : " +e.getMessage());
		}
		
	}

	@Override
	public Customer viewCustomer(int customerId)
	{
		logger.info("******** Getting Customer by Id ********");
		try 
		{
			return customerDao.getOne(customerId);	
		}
		catch (IllegalArgumentException e) 
		{
			throw new CustomerException("Illegal Name" +e.getMessage());
		}
		catch (java.util.NoSuchElementException e)
		{
			throw new CustomerException("No such element : " +e.getMessage());
		}
		
	}

	@Override
	public List<Customer> getCostomers() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	

}
