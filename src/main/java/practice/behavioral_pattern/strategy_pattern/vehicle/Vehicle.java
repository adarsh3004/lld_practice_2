package practice.behavioral_pattern.strategy_pattern.vehicle;

import org.springframework.stereotype.Service;
import practice.behavioral_pattern.strategy_pattern.DriveStrategy;


@Service
public class Vehicle {

    public void printDriveStrategy(DriveStrategy driveStrategy) {
        driveStrategy.drive();
    }
}
