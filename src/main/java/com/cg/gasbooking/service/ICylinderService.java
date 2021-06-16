package com.cg.gasbooking.service;

import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.units.qual.C;
import org.springframework.http.ResponseEntity;

import com.cg.gasbooking.entities.Customer;
import com.cg.gasbooking.entities.Cylinder;



public interface ICylinderService {
	
	

	public List<Cylinder> viewCylinder();
	public Cylinder insertCylinder(Cylinder cylinder);
    public Optional<Cylinder> getCylinder(String type);
    public Cylinder updateCylinder(Cylinder cylinder );
    public void deleteById(int id);
    public List<Cylinder> getCylinder();
    public Cylinder getCylinder(int id);
   
}
