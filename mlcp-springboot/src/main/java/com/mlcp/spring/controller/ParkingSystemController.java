package com.mlcp.spring.controller;

import com.mlcp.spring.exception.BadCommandException;
import com.mlcp.spring.exception.SpotFullException;
import com.mlcp.spring.model.*;
import com.mlcp.spring.service.ParkingLotBookingHistoryService;
import com.mlcp.spring.service.ParkingLotService;
import com.mlcp.spring.service.ParkingSystemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mlcp")
public class ParkingSystemController {


    private final ParkingSystemService parkingSystemService;

    private final ParkingLotService parkingLotService;
    private final ParkingLotBookingHistoryService parkingLotBookingHistoryService;

    public ParkingSystemController(ParkingSystemService parkingSystemService, ParkingLotService parkingLotService, ParkingLotBookingHistoryService parkingLotBookingHistoryService) {
        this.parkingSystemService = parkingSystemService;
        this.parkingLotService = parkingLotService;
        this.parkingLotBookingHistoryService = parkingLotBookingHistoryService;
    }

    @PostMapping("/init")
    public ResponseEntity<String> addFloor(@RequestBody UpdateParkingSystem parkingSystem) {
        return parkingSystemService.init(parkingSystem);
    }

    @PostMapping("/mark-unavailable")
    public ResponseEntity<String> markSpotUnavailable(@RequestBody List<UpdateSpotDetails> unavailableSpots) throws BadCommandException {
        return parkingLotService.markUnavailable(unavailableSpots);
    }

    @PostMapping("/add-floor")
    public ResponseEntity<String> addFloor() {
        return parkingSystemService.addFloor();
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reserveSpot(@RequestBody CustomerDetails customer) throws SpotFullException {
        return parkingLotService.reserveSpot(customer);
    }

    @PostMapping("/vacate")
    public ResponseEntity<String> vacateSpot(@RequestBody UpdateSpotDetails spotDetails) throws BadCommandException {
        return parkingLotService.vacateSpot(spotDetails);
    }

    @GetMapping("/booking-history")
    public ResponseEntity<String> getBookingHistory() {
        return parkingLotBookingHistoryService.getBookingHistory();
    }


}

