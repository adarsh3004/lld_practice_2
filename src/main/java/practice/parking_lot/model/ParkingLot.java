package practice.parking_lot.model;

import java.util.List;

public class ParkingLot {

    private List<ParkingSpot> parkingSpotList;
    private List<EntryGate> entryGate;
    private List<ExitGate> exitGates;

    public ParkingLot(List<ParkingSpot> parkingSpotList, List<EntryGate> entryGate, List<ExitGate> exitGates) {
        this.parkingSpotList = parkingSpotList;
        this.entryGate = entryGate;
        this.exitGates = exitGates;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }
}
