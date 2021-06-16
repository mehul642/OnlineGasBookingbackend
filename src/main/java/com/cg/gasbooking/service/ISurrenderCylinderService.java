package com.cg.gasbooking.service;

import java.util.List;
import java.util.Optional;

import com.cg.gasbooking.entities.SurrenderCylinder;



public interface ISurrenderCylinderService {
	public SurrenderCylinder insertSurrenderCylinder(SurrenderCylinder surrenderCylinder);
	public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder surrenderCylinder);
	public List<SurrenderCylinder> getSurrenderCylinder();
	public int countSurrenserCylinder();
	public void deletById(int id);
}
