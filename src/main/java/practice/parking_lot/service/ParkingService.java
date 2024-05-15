package practice.parking_lot.service;

import practice.parking_lot.enums.VehicleType;
import practice.parking_lot.exception.SpotNotFoundException;
import practice.parking_lot.model.*;
import practice.parking_lot.strategy.ParkingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingService {

    private ParkingLot parkingLot;

    public void createParkingLot(int capacity, int entryGateCount, int exitGateCount) {

        List<ParkingSpot> parkingSpotList = IntStream.range(0, capacity/2).mapToObj(i -> new ParkingSpot((long)i + 1, VehicleType.TWO_WHEELER)).collect(Collectors.toList());
        List<ParkingSpot> fourWheelerParkingSpot = IntStream.range(0, capacity/2).mapToObj(i -> new ParkingSpot((long) i + 1,VehicleType.TWO_WHEELER)).collect(Collectors.toList());
        List<EntryGate> entryGates = IntStream.range(0, capacity).mapToObj(i -> new EntryGate((long) i + 1)).collect(Collectors.toList());
        List<ExitGate> exitGates = IntStream.range(0, exitGateCount).mapToObj(i -> new ExitGate((long) i + 1)).collect(Collectors.toList());
        parkingSpotList.addAll(fourWheelerParkingSpot);
        this.parkingLot = new ParkingLot(parkingSpotList,entryGates,exitGates);
    }

    public boolean assignParkingSpot(Vehicle vehicle, ParkingStrategy parkingStrategy) throws SpotNotFoundException {

        parkingStrategy.park(vehicle,parkingLot);
        return true;
    }

    public void unAssignParkingSpot(Vehicle vehicle) {
        ParkingSpot parkingSpot = getParkingSpot(vehicle);
        if(parkingSpot != null) {
            parkingSpot.setVehicle(null);
            vehicle.setSlotNumber(null);
        }
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle) {
        return parkingLot.getParkingSpotList().stream().filter(parkingSpot -> vehicle.getRegistrationNumber().equals(parkingSpot.getVehicle().getRegistrationNumber())).findFirst().orElse(null);
    }

}
