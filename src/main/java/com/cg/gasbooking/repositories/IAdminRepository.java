package com.cg.gasbooking.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.gasbooking.entities.Admin;



public interface IAdminRepository  extends JpaRepository<Admin, Integer>{

}
