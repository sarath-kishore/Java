
public class ParkingSpot {
    private int spotId;
    private int floorId;
    private boolean isOccupied;
    private boolean isUnderRepair;
    private String customerId;
    private long timestamp;

    ParkingSpot(int spotId, int floorId){
        this.spotId = spotId;
        this.floorId = floorId;
        this.isOccupied = false;
        this.isUnderRepair = false;
        this.customerId = null;
        this.timestamp = -1;
    }

    void setUnderRepair(){
        this.isUnderRepair = true;
    }

    protected boolean isSpotFree(){
        return !this.isOccupied && !this.isUnderRepair;
    }

    protected void populateSpot(String custId){
        this.customerId = custId;
        this.timestamp = System.currentTimeMillis();
        this.isOccupied = true;
    }

    protected int[] getSpotId(){
        return new int[]{this.spotId, this.floorId}; // returns spotId, floorId
    }

    protected long getBookingTime() {
        return this.timestamp;
    }

    protected long releaseSpot() {
        this.customerId = null;
        this.timestamp = -1;
        this.isOccupied = false;
        return System.currentTimeMillis();
    }
}
