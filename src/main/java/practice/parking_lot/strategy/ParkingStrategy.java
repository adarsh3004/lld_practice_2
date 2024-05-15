package practice.parking_lot.strategy;

import practice.parking_lot.exception.SpotNotFoundException;
import practice.parking_lot.model.ParkingLot;
import practice.parking_lot.model.ParkingSpot;
import practice.parking_lot.model.Vehicle;

public interface ParkingStrategy {

    public ParkingSpot park(Vehicle vehicle, ParkingLot parkingLot) throws SpotNotFoundException;
}
