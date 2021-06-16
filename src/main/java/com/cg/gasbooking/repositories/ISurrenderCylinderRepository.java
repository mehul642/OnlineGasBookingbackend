package com.cg.gasbooking.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.gasbooking.entities.SurrenderCylinder;



public interface ISurrenderCylinderRepository  extends JpaRepository<SurrenderCylinder, Integer>{
	
}
