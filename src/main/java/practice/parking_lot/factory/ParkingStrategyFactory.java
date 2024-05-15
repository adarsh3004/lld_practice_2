package practice.parking_lot.factory;

import practice.parking_lot.enums.ParkingStrategyType;
import practice.parking_lot.exception.InvalidInputException;
import practice.parking_lot.strategy.FcfsParkingStrategy;
import practice.parking_lot.strategy.ParkingStrategy;

public class ParkingStrategyFactory {

    public ParkingStrategy getParkingStrategy(String type) throws InvalidInputException {
        if(ParkingStrategyType.valueOf(type).equals(ParkingStrategyType.FCFS)) {
            return new FcfsParkingStrategy();
        }
        throw new InvalidInputException();
    }
}
