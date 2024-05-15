package practice.patterns.behavioral_pattern.strategy_pattern;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StrategyConstructor {

    public static final Map<String, DriveStrategy> mp = new HashMap<>();

    @PostConstruct
    public void init() {
        mp.put("SIMPLE",new SimpleDrive());
        mp.put("COMPLEX",new ComplexDrive());
    }

    public DriveStrategy getStrategy(String key) {
        return mp.get(key);
    }

}
