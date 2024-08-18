
import java.util.List;

public class ParkingSystem {
    private ParkingLot parkingLot;
    private static ParkingSystem instance;
    // for the sake of this exercise, there will be only 1 parking lot with ID=1.
    // if many lots are to be maintained, this variable can be modified to a list.
    ParkingSystem(int floorCount, int spotCount, List<String> spotsUnderRepair){
        parkingLot = new ParkingLot(1, floorCount, spotCount);
        parkingLot.markSpotsUnderRepair(spotsUnderRepair);
    }

    static ParkingSystem getInstance(int floorCount, int spotCount, List<String> spotsUnderRepair){
        if(instance == null)
            instance = new ParkingSystem(floorCount, spotCount, spotsUnderRepair);
        return instance;
    }

    public int[] addVehicle(String custId){
        return parkingLot.addVehicle(custId); // returns spotId, floorId
    }

    public void releaseVehicle(int spotId, int floorId){
        parkingLot.releaseVehicle(spotId, floorId); // returns fee value
    }



}
