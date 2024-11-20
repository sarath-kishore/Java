package com.mlcp.spring.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "parking_system")
@Data
public class ParkingSystem{
    @Id
    private Integer id; // so that there's only one parking system at anytime. change this setting, if needed.
    @Column(name = "floor_count", nullable = false)
    private int floorCount;
    @Column(name = "spot_count", nullable = false)
    private int spotCount;

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getSpotCount() {
        return spotCount;
    }

    public void setSpotCount(int spotCount) {
        this.spotCount = spotCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
