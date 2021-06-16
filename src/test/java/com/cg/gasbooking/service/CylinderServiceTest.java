package com.cg.gasbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.gasbooking.entities.Cylinder;
import com.cg.gasbooking.repositories.ICylinderRepository;
import com.cg.gasbooking.service.*;

@SpringBootTest
public class CylinderServiceTest {
       
	@Autowired
	private CylinderServiceImplement  cylinderService;
	
	@MockBean
	private ICylinderRepository  cylinderDao  ;
	
	Cylinder c1;
	Cylinder c2;
	Cylinder c3;
	Cylinder c4; 
	
	Optional<Cylinder> c;
	
	@BeforeEach
	public void init() {
		c1 = new  Cylinder(1,"LPG",(float)14.5,"blue",(float)1137.0);
		c2 = new Cylinder(2,"LPG",(float)9.5,"blue",(float)847.0);
		c3 = new Cylinder();
		c4 = new Cylinder();
		c=Optional.of(c1);
	}
	@Test
	public void testinsertCylinder() {
		
		when(cylinderDao.save(c1)).thenReturn(c1);
		assertEquals(c1.getCylinderId(), cylinderService.insertCylinder(c1).getCylinderId());
		assertEquals(c1.getType(), cylinderService.insertCylinder(c1).getType());
		assertEquals(c1.getWeight(), cylinderService.insertCylinder(c1).getWeight());
		assertEquals(c1.getStrapColor(), cylinderService.insertCylinder(c1).getStrapColor());
		assertEquals(c1.getPrice(), cylinderService.insertCylinder(c1).getPrice());
	}
	
	@Test
	public void testupdatecylinder() {
		
		when(cylinderDao.existsById(c2.getCylinderId())).thenReturn(true);
		when(cylinderDao.save(c2)).thenReturn(c2);
		assertEquals(c2.getCylinderId(),cylinderService.insertCylinder(c2).getCylinderId());
		assertEquals(c2.getType(), cylinderService.insertCylinder(c2).getType());
		assertEquals(c2.getWeight(), cylinderService.insertCylinder(c2).getWeight());
		assertEquals(c2.getStrapColor(), cylinderService.insertCylinder(c2).getStrapColor());
		assertEquals(c2.getPrice(), cylinderService.insertCylinder(c2).getPrice());	
	}
	
	@Test
	public void testDeletecylinder() {
		
		when(cylinderDao.existsById(c1.getCylinderId())).thenReturn(true);
		cylinderDao.delete(c1);
		verify(cylinderDao, times(1)).delete(c1);
	}
}
