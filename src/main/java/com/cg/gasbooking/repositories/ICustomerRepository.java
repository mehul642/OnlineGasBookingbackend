package com.cg.gasbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gasbooking.entities.Customer;



@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

}
