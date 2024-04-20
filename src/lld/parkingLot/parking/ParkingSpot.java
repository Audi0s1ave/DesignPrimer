package lld.parkingLot.parking;

import lld.parkingLot.enums.ParkingSpotType;
import lld.parkingLot.vehicles.Vehicle;

public class ParkingSpot {
    private ParkingSpotType parkingSpotType;
    private Vehicle vehicle;
    private String ParkingSpotNo;

    public ParkingSpot(ParkingSpotType parkingSpotType, Vehicle vehicle) {
        this.parkingSpotType = parkingSpotType;
        this.vehicle = vehicle;
    }
}
