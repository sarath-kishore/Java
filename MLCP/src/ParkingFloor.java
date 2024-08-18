import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> spots;
    private int floorId;
    private int lotId;
    ParkingFloor(int floorId, int spotCount, int lotId){
        this.floorId = floorId;
        this.lotId = lotId;
        this.spots = new ArrayList<>();
        for(int i=0; i<spotCount; i++){
            this.spots.add(new ParkingSpot(i, floorId));
        }
    }

    List<ParkingSpot> getSpots(){
        return spots;
    }

    void markSpotUnderRepair(int spotId){
        spots.get(spotId).setUnderRepair();
    }
}
