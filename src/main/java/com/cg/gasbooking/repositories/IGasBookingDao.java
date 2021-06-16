package com.cg.gasbooking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.gasbooking.entities.GasBooking;



public interface IGasBookingDao extends JpaRepository<GasBooking, Integer> {
Optional<GasBooking> findBycustomerId(int id);

}
