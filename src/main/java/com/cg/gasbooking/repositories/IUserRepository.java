package com.cg.gasbooking.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.gasbooking.entities.Admin;



@Repository
public interface IUserRepository extends JpaRepository<Admin, Integer>{
	
	@Query("from Admin where username=:uname")
	Admin findByUsername(@Param("uname") String username);
	
}
