package com.cg.gasbooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.gasbooking.entities.Cylinder;

public interface ICylinderRepository extends JpaRepository<Cylinder, Integer> {
    Optional<Cylinder> findByType(String type);
    
}
