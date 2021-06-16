package com.cg.gasbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.gasbooking.entities.Customer;

@Repository
public interface IUserRepository1  extends JpaRepository<Customer, Integer> {

	@Query("from Customer where username=:uname")
	Customer findByUsername(@Param("uname") String username);
}
