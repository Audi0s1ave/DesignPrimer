package lld.parkingLot.vehicles;

import lld.parkingLot.parking.ParkingTicket;
import lld.parkingLot.enums.VehicleType;

public abstract class Vehicle {
    private VehicleType vehicleType;
    private ParkingTicket parkingTicket;
    String licensePlate;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


}
