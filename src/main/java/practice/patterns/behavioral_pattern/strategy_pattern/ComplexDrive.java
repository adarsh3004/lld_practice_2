package practice.patterns.behavioral_pattern.strategy_pattern;

import org.springframework.stereotype.Service;

@Service
public class ComplexDrive implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println(" -- running Complex drive ---- ");
    }
}
