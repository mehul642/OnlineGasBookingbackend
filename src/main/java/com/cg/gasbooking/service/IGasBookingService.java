package com.cg.gasbooking.service;

import java.util.Optional;
import java.util.*;
import com.cg.gasbooking.entities.GasBooking;


public interface IGasBookingService {

	public GasBooking insertGasBooking(GasBooking gasBooking);
	public GasBooking updateGasBooking(GasBooking gasBooking);
	public GasBooking deleteGasBooking(int gasBookingId);
	public Optional<GasBooking> getBill(int id);
	public List<GasBooking> getBooking();
}
