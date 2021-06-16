package com.cg.gasbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.gasbooking.entities.GasBooking;
import com.cg.gasbooking.repositories.IGasBookingDao;


@SpringBootTest
class GasBookingServiceTest {

	@Autowired
	private GasBookingServiceImplementation gasBookingService;
	
	@MockBean
	private IGasBookingDao gasBookingDao;
	
	GasBooking gb1;
	GasBooking gb2;
	Optional<GasBooking> gb;
	
	@BeforeEach
	public void init() {
		gb1 = new GasBooking(1,2,LocalDate.now(),true,870);
		gb2 = new GasBooking(5,6,LocalDate.now(),true,900);
		gb = Optional.of(gb1);
	}
	
	@Test
	public void testInsertGasBooking() {
		
		when(gasBookingDao.save(gb1)).thenReturn(gb1);
	    assertEquals(gb1.getGasBookingId(), gasBookingService.insertGasBooking(gb1).getGasBookingId());
		assertEquals(gb1.getCustomerId(), gasBookingService.insertGasBooking(gb1).getCustomerId());
		assertEquals(gb1.getBookingDate(), gasBookingService.insertGasBooking(gb1).getBookingDate());
		assertEquals(gb1.isStatus(), gasBookingService.insertGasBooking(gb1).isStatus());
		assertEquals(gb1.getBill(), gasBookingService.insertGasBooking(gb1).getBill());
	}
	
	@Test
	public void testUpdateGasBooking() {
		when(gasBookingDao.existsById(gb2.getGasBookingId())).thenReturn(true);
		when(gasBookingDao.save(gb2)).thenReturn(gb2);
		assertEquals(gb2.getGasBookingId(), gasBookingService.updateGasBooking(gb2).getGasBookingId());
		assertEquals(gb2.getCustomerId(), gasBookingService.updateGasBooking(gb2).getCustomerId());
		assertEquals(gb2.getBookingDate(), gasBookingService.updateGasBooking(gb2).getBookingDate());
		assertEquals(gb2.isStatus(), gasBookingService.updateGasBooking(gb2).isStatus());
		assertEquals(gb2.getBill(), gasBookingService.updateGasBooking(gb2).getBill());
	}
	
	@Test
	public void testdeleteGasBooking() {
		//System.out.println(gasBookingDao.existsById(4)+" inside delete");
		when(gasBookingDao.existsById(gb1.getGasBookingId())).thenReturn(true);
		gasBookingDao.delete(gb1);
		verify(gasBookingDao, times(1)).delete(gb1);
	}
	
	@Test
	public void testGetBill() {
		when(gasBookingDao.findBycustomerId(gb1.getCustomerId())).thenReturn(gb);
		assertEquals(gb1.getBill(), gasBookingService.getBill(2).get().getBill());
	}

}
