package practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import practice.key_value_store.exception.InvalidKeyException;
import practice.key_value_store.model.Value;
import practice.key_value_store.service.KeyValueStoreService;
import practice.parking_lot.enums.VehicleType;
import practice.parking_lot.exception.InvalidInputException;
import practice.parking_lot.exception.SpotNotFoundException;
import practice.parking_lot.factory.ParkingStrategyFactory;
import practice.parking_lot.model.Bike;
import practice.parking_lot.model.Car;
import practice.parking_lot.service.ParkingService;
import practice.parking_lot.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);

        PatternPracticeDryRun patternPracticeDryRun = new PatternPracticeDryRun();
        patternPracticeDryRun.run();

        parkingSpotDryRun();

        keyValueStoreRun();
    }

    public static void keyValueStoreRun() throws InvalidKeyException {

        // TODO :: Make it thread safe

        KeyValueStoreService keyValueStoreService = new KeyValueStoreService();

        // Put
        Value vl = new Value("title","SDE-Bootcamp");
        Value vl1 = new Value("price",3000.0);
        Value vl2 = new Value("enrolled",false);
        Value vl3 = new Value("estimated_time",30);
        List<Value> lst = new ArrayList<>(Arrays.asList(vl, vl1, vl2, vl3));
        keyValueStoreService.put("sde_bootcamp",lst);
        // get
        System.out.println(keyValueStoreService.get("sde_bootcamp"));
        //keys
        System.out.println(keyValueStoreService.keys());



        // Put
        vl = new Value("title","SDE-Kickstart");
        vl1 = new Value("price",4000.0);
        vl2 = new Value("enrolled",true);
        vl3 = new Value("estimated_time",8);
        lst = new ArrayList<>(Arrays.asList(vl, vl1, vl2, vl3));
        keyValueStoreService.put("sde_kickstart",lst);
        // get
        System.out.println(keyValueStoreService.get("sde_kickstart"));
        //keys
        System.out.println(keyValueStoreService.keys());


        //delete
        keyValueStoreService.delete("sde_bootcamp");
        // get
        System.out.println(keyValueStoreService.get("sde_bootcamp"));
        //keys
        System.out.println(keyValueStoreService.keys());


        // Put
        vl = new Value("title","SDE-Bootcamp");
        vl1 = new Value("price",30000.0);
        vl2 = new Value("enrolled",true);
        vl3 = new Value("estimated_time",30);
        lst = new ArrayList<>(Arrays.asList(vl, vl1, vl2, vl3));
        keyValueStoreService.put("sde_bootcamp",lst);

        // search
        System.out.println(keyValueStoreService.search("price",30000.0));
        // search
        System.out.println(keyValueStoreService.search("enrolled",true));
    }


    public static void parkingSpotDryRun() throws InvalidInputException, SpotNotFoundException {

        ParkingService parkingService = new ParkingService();
        parkingService.createParkingLot(100,2,2);

        // Create Few Vehicles
        Car car = new Car("ABC123", VehicleType.FOUR_WHEELER);
        Bike bike = new Bike("ABC124", VehicleType.TWO_WHEELER);
        Bike bike1 = new Bike("ABC125", VehicleType.TWO_WHEELER);

        // Get Parking Strategy
        ParkingStrategyFactory parkingStrategyFactory = new ParkingStrategyFactory();
        ParkingStrategy parkingStrategy = parkingStrategyFactory.getParkingStrategy("FCFS");

        System.out.println("Assign Parking to Vehicles");
        parkingService.assignParkingSpot(car,parkingStrategy);
        parkingService.assignParkingSpot(bike,parkingStrategy);
        parkingService.assignParkingSpot(bike1,parkingStrategy);
        System.out.println();


        System.out.println("Check Slots of each vehicles");
        parkingService.getParkingSpot(car);
        parkingService.getParkingSpot(bike);
        parkingService.getParkingSpot(bike1);



        System.out.println("Un-assign few slots");
        parkingService.unAssignParkingSpot(car);
        parkingService.unAssignParkingSpot(bike1);
        System.out.println();

        System.out.println("Check Slots of each vehicles");
        parkingService.getParkingSpot(car);
        parkingService.getParkingSpot(bike);
        parkingService.getParkingSpot(bike1);
        System.out.println();
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
