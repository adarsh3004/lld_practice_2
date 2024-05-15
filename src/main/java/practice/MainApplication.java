package practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import practice.parking_lot.enums.VehicleType;
import practice.parking_lot.exception.InvalidInputException;
import practice.parking_lot.factory.ParkingStrategyFactory;
import practice.parking_lot.model.Bike;
import practice.parking_lot.model.Car;
import practice.parking_lot.service.ParkingService;
import practice.parking_lot.strategy.ParkingStrategy;

import java.util.Arrays;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);

        PatternPracticeDryRun patternPracticeDryRun = new PatternPracticeDryRun();
        patternPracticeDryRun.run();

        parkingSpotDryRun();
    }

    public static void parkingSpotDryRun() throws InvalidInputException {

        ParkingService parkingService = new ParkingService();
        parkingService.createParkingLot(100,2,2);

        // Create Few Vehicles
        Car car = new Car("ABC123", VehicleType.FOUR_WHEELER);
        Bike bike = new Bike("ABC124", VehicleType.TWO_WHEELER);
        Bike bike1 = new Bike("ABC125", VehicleType.TWO_WHEELER);

        // Get Parking Strategy
        ParkingStrategyFactory parkingStrategyFactory = new ParkingStrategyFactory();
        ParkingStrategy parkingStrategy = parkingStrategyFactory.getParkingStrategy("FCFS");

        // TODO :: Assign Parking to Vehicles

        // TODO :: Check Slots of each vehicles

        // TODO :: Un-assign few slots
    }



    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
