package com.mlcp.spring.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "spot_id", nullable = false)
    private int spotId;

    @Column(name = "floor_id", nullable = false)
    private int floorId;

    @Column(name = "is_occupied", nullable = false)
    private boolean isOccupied;

    @Column(name = "is_under_repair", nullable = false)
    private boolean isUnderRepair;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // Constructors
    public ParkingSpot() {}

    public ParkingSpot(int spotId, int floorId) {
        this.spotId = spotId;
        this.floorId = floorId;
        this.isOccupied = false;
        this.isUnderRepair = false;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isUnderRepair() {
        return isUnderRepair;
    }

    public void setUnderRepair(boolean underRepair) {
        isUnderRepair = underRepair;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
