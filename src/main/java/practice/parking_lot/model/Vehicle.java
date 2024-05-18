package practice.parking_lot.model;

import practice.parking_lot.enums.VehicleType;

public class Vehicle {

    private final String registrationNumber;
    private Long slotNumber;
    private final VehicleType vehicleType;

    public Vehicle(final String registrationNumber,final VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Long getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Long slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
