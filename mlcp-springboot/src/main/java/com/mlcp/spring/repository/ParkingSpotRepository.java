package com.mlcp.spring.repository;

import com.mlcp.spring.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {
    ParkingSpot findByFloorIdAndSpotId(int floorId, int spotId);

    @Query(value = "SELECT * FROM parking_spots WHERE is_occupied = false AND is_under_repair = false ORDER BY id ASC LIMIT 1", nativeQuery = true)
    ParkingSpot findOpenSpot();
}

