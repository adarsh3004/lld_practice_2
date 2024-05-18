package practice.parking_lot.model;

import practice.parking_lot.enums.VehicleType;

public class FourWheelerSpot extends ParkingSpot{
    public FourWheelerSpot(Long slotNumber) {
        super(slotNumber,VehicleType.FOUR_WHEELER);
    }
}
