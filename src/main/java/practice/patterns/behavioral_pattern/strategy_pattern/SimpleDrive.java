package practice.patterns.behavioral_pattern.strategy_pattern;

import org.springframework.stereotype.Service;

@Service
public class SimpleDrive implements DriveStrategy{

    public void drive() {
        System.out.println(" -- running simple drive ---- ");
    }
}
