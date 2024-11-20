package com.mlcp.spring.model;
import jakarta.persistence.*;

@Entity
@Table(name = "parking_history")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int spotId;
    private int floorId;
    private int fee;
    private long duration;
    private String custId;

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

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString(){
        return "Booking: " + this.id + ", spot: " + this.spotId + ", floor: " + this.floorId
                + ", duration: " + this.duration + ", fee: " + this.fee;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
