package com.cg.gasbooking.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.gasbooking.entities.Admin;
import com.cg.gasbooking.repositories.IAdminRepository;
import com.cg.gasbooking.service.AdminServiceImplement;



@SpringBootTest
public class IAdminServiceTest {


	@Autowired
	private AdminServiceImplement adminServiceImplement ;

	@MockBean
	private IAdminRepository adminRepository;

	Admin A1;
	Admin A2;
	Admin A3;
	Admin A4;
	Admin A5;
	
	
	@BeforeEach
	public void init() {
		A1 = new Admin(1,"mehul","dgsg","3154547","mehul@gmail.com");
		A2 = new Admin(2,"Amey","amey","123456789","amey@gmail.com");
		A3 = new Admin();
		A4 = new Admin();
		A5 = new Admin();
	}
	
	@Test
	public void testinsertAdmin() {
		
		when(adminRepository.save(A1)).thenReturn(A1);
		assertEquals(A1.getAdminId(), adminServiceImplement.insertAdmin(A1).getAdminId());
		assertEquals(A1.getUsername(), adminServiceImplement.insertAdmin(A1).getUsername());
		assertEquals(A1.getPassword(), adminServiceImplement.insertAdmin(A1).getPassword());
		
		
	}
	
	@Test
	public void testupdateAdmin() {
		
		when(adminRepository.existsById(A2.getAdminId())).thenReturn(true);
		when(adminRepository.save(A1)).thenReturn(A1);
		assertEquals(A2.getAdminId(), adminServiceImplement.updateAdmin(A2).getAdminId());
		assertEquals(A2.getUsername(), adminServiceImplement.updateAdmin(A2).getUsername());
		assertEquals(A2.getPassword(), adminServiceImplement.updateAdmin(A2).getPassword());	
	}
	
	@Test
	public void testDeleteAdmin() {
		
		when(adminRepository.existsById(A1.getAdminId())).thenReturn(true);
		adminRepository.delete(A1);
		verify(adminRepository, times(1)).delete(A1);
	}
}
