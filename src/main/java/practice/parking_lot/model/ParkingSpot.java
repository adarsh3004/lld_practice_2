package practice.parking_lot.model;

import practice.parking_lot.enums.VehicleType;

public class ParkingSpot {

    private final Long slotNumber;
    private Vehicle vehicle;
    private final VehicleType spotType;

    public ParkingSpot(final Long slotNumber,final VehicleType spotType) {
        this.slotNumber = slotNumber;
        this.spotType = spotType;
    }

    public Long getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getSpotType() {
        return spotType;
    }
}
