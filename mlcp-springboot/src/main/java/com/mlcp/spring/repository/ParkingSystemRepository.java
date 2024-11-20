package com.mlcp.spring.repository;

import com.mlcp.spring.model.ParkingSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSystemRepository extends JpaRepository<ParkingSystem, Long> {
    List<ParkingSystem> findAllById(Long id);
}
