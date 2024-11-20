package com.mlcp.spring.service;

import com.mlcp.spring.model.Booking;
import com.mlcp.spring.repository.ParkingSpotBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotBookingHistoryService {
    @Autowired
    private ParkingSpotBookingsRepository parkingSpotBookingsRepository;

    public void addBookingHistory(Booking booking){
        parkingSpotBookingsRepository.save(booking);
    }

    public ResponseEntity<String> getBookingHistory() {
        List<Booking> list = parkingSpotBookingsRepository.findAll();
        if(list == null){
            System.out.println("No history found");
            return ResponseEntity.ok("Booking history not found");
        }
        System.out.println("booking list: " + list);
        System.out.println("---------------");
        for(Booking booking : list){
            System.out.println(booking);
        }

        return ResponseEntity.ok("Booking history"); // return list of booking history
    }
}
