package com.mlcp.spring.service;


import com.mlcp.spring.model.ParkingSpot;
import com.mlcp.spring.model.ParkingSystem;
import com.mlcp.spring.model.UpdateParkingSystem;
import com.mlcp.spring.repository.ParkingSystemRepository;
import com.mlcp.spring.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSystemService {

    private ParkingSystemRepository parkingSystemRepository;

    private ParkingLotService parkingLotService;

    private ParkingSystem system;
    public ParkingSystemService(ParkingSystemRepository parkingSystemRepository, ParkingLotService parkingLotService){
        this.parkingSystemRepository = parkingSystemRepository;
        this.parkingLotService = parkingLotService;

        List<Long> ids = List.of(1l);
        List<ParkingSystem> list= parkingSystemRepository.findAllById(ids);
        if(list.size() > 0){
            // system already initialised
            this.system = list.get(0);
        }else{
            ParkingSystem parkingSystem = new ParkingSystem();
            parkingSystem.setId(1);
            parkingSystem.setSpotCount(10);
            parkingSystem.setFloorCount(1);
            this.system = parkingSystem;
            parkingSystemRepository.save(parkingSystem);

            parkingLotService.init(10, 1);
        }
    }
    public ResponseEntity<String> init(UpdateParkingSystem updateParkingSystem){
        // supposed to be used to reset the system with new values for spot and floor count
        ParkingSystem parkingSystem = new ParkingSystem();
        parkingSystem.setId(1);
        parkingSystem.setFloorCount(updateParkingSystem.getFloorCount());
        parkingSystem.setSpotCount(updateParkingSystem.getSpotCount());
        this.system = parkingSystem;
        parkingSystemRepository.save(parkingSystem);
        return parkingLotService.init(updateParkingSystem.getSpotCount(), updateParkingSystem.getFloorCount());
    }


    public ResponseEntity<String> addFloor() {
        this.system.setFloorCount(this.system.getFloorCount()+1);
        parkingSystemRepository.save(this.system);
        parkingLotService.addFloor(this.system.getSpotCount(), this.system.getFloorCount());
        System.out.println("updated floor count: " + this.system.getFloorCount());
        return ResponseEntity.ok("new floor added");
    }


}
