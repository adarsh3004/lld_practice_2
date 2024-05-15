package practice.parking_lot.strategy;

import practice.parking_lot.exception.SpotNotFoundException;
import practice.parking_lot.model.ParkingLot;
import practice.parking_lot.model.ParkingSpot;
import practice.parking_lot.model.Vehicle;

public class FcfsParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot park(Vehicle vehicle, ParkingLot parkingLot) throws SpotNotFoundException {

        for(ParkingSpot parkingSpot : parkingLot.getParkingSpotList()) {
            if(vehicle.getVehicleType().equals(parkingSpot.getSpotType())
                && parkingSpot.getVehicle() == null)
                return parkingSpot;
        }
        throw new SpotNotFoundException();
    }
}
