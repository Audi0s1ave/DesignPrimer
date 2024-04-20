package lld.parkingLot.parking;

import lld.parkingLot.enums.ParkingSpotType;
import lld.parkingLot.enums.ParkingTicketStatus;
import lld.parkingLot.enums.VehicleType;
import lld.parkingLot.vehicles.Vehicle;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Stack;

public class ParkingFloor {
    private Integer floorNumber;
    private Map<ParkingSpotType, Integer> freeSpots;
    private Map<ParkingSpotType, Stack<ParkingSpot>> parkingSpots;

    public Integer display(VehicleType vehicleType){
        return freeSpots.get(getParkingSpotType(vehicleType));
    }

    private ParkingSpotType getParkingSpotType(VehicleType vehicleType){
        switch (vehicleType) {
            case CAR:
                return ParkingSpotType.COMPACT;
            case VAN:
            case TRUCK:
                return ParkingSpotType.LARGE;
            case BIKE:
                return ParkingSpotType.MOTORBIKE;
            case ELECTRIC:
                return ParkingSpotType.ELECTRIC;
        }
        return ParkingSpotType.HANDICAPPED;

    }

    public Boolean enter(Vehicle vehicle){
        if(display(vehicle.getVehicleType()) == 0){
            return Boolean.FALSE;
        }
        freeSpots.put(getParkingSpotType(vehicle.getVehicleType()), freeSpots.get(getParkingSpotType(vehicle.getVehicleType()))+1);
        parkingSpots.get(getParkingSpotType(vehicle.getVehicleType())).push(new ParkingSpot(getParkingSpotType(vehicle.getVehicleType()), vehicle));
        return Boolean.TRUE;

    }

    public Double exit(Vehicle vehicle){
        freeSpots.put(getParkingSpotType(vehicle.getVehicleType()), freeSpots.get(getParkingSpotType(vehicle.getVehicleType()))-1);
        parkingSpots.get(getParkingSpotType(vehicle.getVehicleType())).pop();
        if(vehicle.getParkingTicket().parkingTicketStatus == ParkingTicketStatus.ACTIVE) {
            return getParkingFee(vehicle);
        }
        return 0.0;
    }

    public Double customerInfo(){
        return null;

    }

    private Double getParkingFee(Vehicle vehicle){
        return ChronoUnit.HOURS.between(vehicle.getParkingTicket().entryTime , LocalDateTime.now()) * 4.0;

    }



}
