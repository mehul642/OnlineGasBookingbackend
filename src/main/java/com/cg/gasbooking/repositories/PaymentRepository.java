package com.cg.gasbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gasbooking.entities.Payment;




@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
