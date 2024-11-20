package com.mlcp.spring.repository;

import com.mlcp.spring.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotBookingsRepository extends JpaRepository<Booking, Integer> {
}
