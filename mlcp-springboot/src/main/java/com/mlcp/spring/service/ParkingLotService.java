package com.mlcp.spring.service;
import com.mlcp.spring.exception.BadCommandException;
import com.mlcp.spring.exception.SpotFullException;
import com.mlcp.spring.model.*;
import com.mlcp.spring.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.Duration;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;
    @Autowired
    private ParkingLotBookingHistoryService parkingLotBookingHistoryService;
    public ResponseEntity<String> init(int spot_count, int floor_count) {
        parkingSpotRepository.deleteAll();
        for(int f = 1; f <= floor_count; f++){
            addFloor(spot_count, f);
        }

        return ResponseEntity.ok("Db initialized successfully.");
    }

    public boolean addFloor(int spot_count, int f){
        List<ParkingSpot> list = new ArrayList<>();
        for(int s = 1; s <= spot_count; s++){
            ParkingSpot spot = new ParkingSpot();
            spot.setSpotId(s);
            spot.setFloorId(f);
            spot.setUnderRepair(false);
            spot.setOccupied(false);
            spot.setCustomerId(null);
            spot.setTimestamp(null);
            list.add(spot);
        }
        parkingSpotRepository.saveAll(list);
        return true;
    }

    public ResponseEntity<String> markUnavailable(List<UpdateSpotDetails> unavailableSpots) throws BadCommandException {
// check if db is initialised first. throw exception
        List<ParkingSpot> list = new ArrayList<>();
        for(UpdateSpotDetails spotDetails : unavailableSpots){
            // Fetch the existing ParkingSystem object based on floorId and spotId
            ParkingSpot spot = parkingSpotRepository.findByFloorIdAndSpotId(spotDetails.getFloorId(), spotDetails.getSpotId());

            if (spot != null) {
                // Update the values
                if(spot.isOccupied()){
                    throw new BadCommandException("Parking spot under use. cannot go under repair now.");
                }
                spot.setUnderRepair(true);
                list.add(spot);
            } else {
                // If the record is not found, return null or throw an exception as needed
                throw new BadCommandException("Parking spot not found for the given floorId and spotId");
            }
        }

        // Save the updated ParkingSystem back to the database
        parkingSpotRepository.saveAll(list);
        return ResponseEntity.ok("Spots marked as unavailable.");
    }

    public ResponseEntity<String> reserveSpot(CustomerDetails customer) throws SpotFullException {
        ParkingSpot spot = parkingSpotRepository.findOpenSpot();
        if(spot==null) {
//            return ResponseEntity.ok("Lot full. Spot could not be reserved.");
            throw new SpotFullException("Lot full. Spot could not be reserved.");
        }

        spot.setCustomerId(customer.getCustId());
        spot.setTimestamp(LocalDateTime.now());
        spot.setOccupied(true);

        parkingSpotRepository.save(spot);

        System.out.println("Spot reserved: " + spot.getSpotId() + " - " + spot.getFloorId());
        return ResponseEntity.ok("Spot  has been reserve."); // return spot id and floor id
    }

    public ResponseEntity<String> vacateSpot(UpdateSpotDetails spotDetails) throws BadCommandException {
        ParkingSpot spot = parkingSpotRepository.findByFloorIdAndSpotId(spotDetails.getFloorId(), spotDetails.getSpotId());

        if(spot.isUnderRepair())
            throw new BadCommandException("Parking spot under repair and not in use. enter valid ID");

        LocalDateTime startTime = spot.getTimestamp();
        LocalDateTime endTime = LocalDateTime.now();

        Duration duration = Duration.between(startTime, endTime);
        // Get difference in different time units
        long seconds = duration.getSeconds();
        int fee = calculateFee(seconds);
        Booking booking = new Booking();
        booking.setSpotId(spot.getSpotId());
        booking.setFloorId(spot.getFloorId());
        booking.setDuration(seconds);
        booking.setFee(fee);
        booking.setCustId(spot.getCustomerId());

        spot.setOccupied(false);
        spot.setCustomerId(null);
        spot.setTimestamp(null);

        parkingSpotRepository.save(spot);
        parkingLotBookingHistoryService.addBookingHistory(booking);

        System.out.println("Spot vacated: "+ spot.getSpotId() + " - " + spot.getFloorId() + " | fee: " + fee);
        return ResponseEntity.ok("Spot  has been vacated."); // return total duration used and fee
    }

    private int calculateFee(long duration){
        int fee = 10; // per second
        System.out.println("duration: " + duration);
        System.out.println("calc: " + (int)(Math.ceil(duration/100)));
        return (int)(Math.ceil(duration/100) * fee);
    }


}
