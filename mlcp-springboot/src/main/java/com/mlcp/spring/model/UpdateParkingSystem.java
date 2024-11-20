package com.mlcp.spring.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UpdateParkingSystem{
    private int id;
    private int floorCount = 1;
    private int spotCount = 10;

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
}
