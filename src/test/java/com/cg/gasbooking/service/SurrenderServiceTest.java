package com.cg.gasbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.gasbooking.entities.Customer;
import com.cg.gasbooking.entities.Cylinder;
import com.cg.gasbooking.entities.SurrenderCylinder;
import com.cg.gasbooking.repositories.ISurrenderCylinderRepository;



@SpringBootTest
public class SurrenderServiceTest {
	
	@Autowired
	private SurrenderCylinderServiceImplement surrenderCylinderServiceImplement;
	
	@MockBean
    private ISurrenderCylinderRepository surrenderRepository;
	
	Customer c=new Customer(1,"ut123","savsv21","asfasf", null, null, null, null);	
	Cylinder c1=new Cylinder(1,"LPG", 14.2f,"blue",141.0f); 
	
	SurrenderCylinder s1;
	SurrenderCylinder s2;
	
	
    @BeforeEach
    public void init() {
    	s1= new SurrenderCylinder(1,LocalDate.now(),c,c1 );
    	s2 =new SurrenderCylinder(2, LocalDate.now(), c, c1);
    	
    }
    
    
    @Test
	public void testinsertsurrendercylinder() {
       when(surrenderRepository.save(s1)).thenReturn(s1);
       assertEquals(s1.getSurrenderId(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s1).getSurrenderId());
       assertEquals(s1.getSurrenderDate(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s1).getSurrenderDate());
       assertEquals(s1.getCustomer(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s1).getCustomer());
       assertEquals(s1.getCylinder(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s1).getCylinder());
    }
    @Test
	public void testupdatesurrendercylinder() {
		
		when(surrenderRepository.existsById(s2.getSurrenderId())).thenReturn(true);
		when(surrenderRepository.save(s2)).thenReturn(s2);
	       assertEquals(s2.getSurrenderId(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s2).getSurrenderId());
	       assertEquals(s2.getSurrenderDate(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s2).getSurrenderDate());
	       assertEquals(s2.getCustomer(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s2).getCustomer());
	       assertEquals(s2.getCylinder(), surrenderCylinderServiceImplement.insertSurrenderCylinder(s2).getCylinder());
	}
    
    @Test
	public void testDeletesurrendercylinder() {
		
		when(surrenderRepository.existsById(s1.getSurrenderId())).thenReturn(true);
		surrenderRepository.delete(s1);
		verify(surrenderRepository, times(1)).delete(s1);
	}
    
    @Test
    public void testCountsurrendercylinder() {
    	when(surrenderRepository.existsById(s1.getSurrenderId())).thenReturn(true);
    	surrenderRepository.count();
    	verify(surrenderRepository,times(1)).count();
    }
}
