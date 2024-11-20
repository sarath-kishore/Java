package com.mlcp.spring.model;

import lombok.Data;

@Data
public class UpdateSpotDetails {
    private int spotId;
    private int floorId;



    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }
}
