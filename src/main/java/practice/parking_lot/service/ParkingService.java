package practice.parking_lot.service;

import practice.parking_lot.enums.VehicleType;
import practice.parking_lot.exception.SpotNotFoundException;
import practice.parking_lot.model.*;
import practice.parking_lot.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingService {

    private ParkingLot parkingLot;

    public void createParkingLot(int capacity, int entryGateCount, int exitGateCount) {

        int j = 0;
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        int bound = capacity / 2;
        for (int i1 = 0; i1 < bound; i1++) {
            TwoWheelerSpot twoWheelerSpot = new TwoWheelerSpot((long)++j);
            parkingSpotList.add(twoWheelerSpot);
        }

        List<ParkingSpot> fourWheelerParkingSpot = new ArrayList<>();
        for (int i1 = 0; i1 < bound; i1++) {
            FourWheelerSpot fourWheelerSpot = new FourWheelerSpot((long)++j);
            fourWheelerParkingSpot.add(fourWheelerSpot);
        }

        List<EntryGate> entryGates = IntStream.range(0, capacity).mapToObj(i -> new EntryGate((long) i + 1)).collect(Collectors.toList());
        List<ExitGate> exitGates = IntStream.range(0, exitGateCount).mapToObj(i -> new ExitGate((long) i + 1)).collect(Collectors.toList());

        parkingSpotList.addAll(fourWheelerParkingSpot);
        this.parkingLot = new ParkingLot(parkingSpotList,entryGates,exitGates);
    }

    public boolean assignParkingSpot(Vehicle vehicle, ParkingStrategy parkingStrategy) throws SpotNotFoundException {

        ParkingSpot parkingSpot = parkingStrategy.park(vehicle,parkingLot);
        parkingSpot.setVehicle(vehicle);
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
        for (ParkingSpot parkingSpot : parkingLot.getParkingSpotList()) {
            if (Objects.nonNull(parkingSpot.getVehicle()) && vehicle.getRegistrationNumber().equals(parkingSpot.getVehicle().getRegistrationNumber())) {
                System.out.println("For vehicle :" + vehicle.getRegistrationNumber() + " Parking Spot is = " + parkingSpot.getSlotNumber());
                return parkingSpot;
            }
        }
        return null;
    }

}
