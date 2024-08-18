import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> floors;
    private int lotId;

    ParkingLot(int lotId, int floorCount, int spotCount){
        this.lotId = lotId;
        this.floors = new ArrayList<>();
        for(int i=0; i<floorCount; i++){
            this.floors.add(new ParkingFloor(i, spotCount, lotId));
        }
    }

    List<ParkingFloor> getFloors(){
        return floors;
    }

    public void markSpotsUnderRepair(List<String> spotsUnderRepair){
        for(String str : spotsUnderRepair){
            int floorId = Integer.parseInt(str.split("-")[0]);
            int spotId = Integer.parseInt(str.split("-")[1]);

            ParkingFloor floor = floors.get(floorId);
            floor.markSpotUnderRepair(spotId);
        }
    }

    protected int[] addVehicle(String custId) {
        ParkingSpot openSpot = getSpot();
        if(openSpot == null)
            return new int[]{-1,-1};

        openSpot.populateSpot(custId);
        System.out.println("Vehicle belonging to " + custId + " is parked at spot " + openSpot.getSpotId()[0] + " , on floor " + openSpot.getSpotId()[1] + ".");
        return openSpot.getSpotId(); // returns spotId, floorId
    }

    protected void releaseVehicle(int spotId, int floorId){
        if(floorId >= floors.size()) {
            System.out.println("Invalid floor. Try again.");
            return;
        }
        ParkingFloor floor = floors.get(floorId);

        if(spotId >= floor.getSpots().size()) {
            System.out.println("Invalid spot. Try again.");
            return;
        }

        ParkingSpot spot = floor.getSpots().get(spotId);
        long startTime = spot.getBookingTime();

        if(startTime<0) {
            System.out.println("Spot empty!");
            return;
        }
        long endTime = spot.releaseSpot();
        System.out.println("start: " + startTime + " | end: " + endTime);
        int fee = calculateFee(endTime - startTime);
            System.out.println("Vehicle released. Fee: " + fee);

    }

    private int calculateFee(long duration){
        int fee = 10; // per second
        System.out.println("duration: " + duration);
        return (int)(Math.ceil(duration/1000) * fee);
    }

    private ParkingSpot getSpot(){
        for(ParkingFloor floor : floors){
            for(ParkingSpot spot : floor.getSpots()){
                if(spot.isSpotFree()){
                    System.out.println("Open spot found!");
                    return spot;
                }
            }
        }

        System.out.println("No spots are available!");
        return null;
    }
}
