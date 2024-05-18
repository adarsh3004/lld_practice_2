package practice.parking_lot.model;

import practice.parking_lot.enums.VehicleType;

public class TwoWheelerSpot extends ParkingSpot{

    public TwoWheelerSpot(Long slotNumber) {
        super(slotNumber, VehicleType.TWO_WHEELER);
    }
}
