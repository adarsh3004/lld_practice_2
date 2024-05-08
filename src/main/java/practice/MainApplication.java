package practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import practice.behavioral_pattern.command_pattern.Controller;
import practice.behavioral_pattern.command_pattern.commands.Command;
import practice.behavioral_pattern.command_pattern.commands.FanOffCommand;
import practice.behavioral_pattern.command_pattern.commands.LightOffCommand;
import practice.behavioral_pattern.command_pattern.commands.LightOnCommand;
import practice.behavioral_pattern.command_pattern.receiver.Fan;
import practice.behavioral_pattern.command_pattern.receiver.Light;
import practice.behavioral_pattern.iterator_pattern.Profile;
import practice.behavioral_pattern.iterator_pattern.aggregate.Facebook;
import practice.behavioral_pattern.iterator_pattern.aggregate.Linkedin;
import practice.behavioral_pattern.iterator_pattern.aggregate.SocialNetwork;
import practice.behavioral_pattern.iterator_pattern.iterator.ProfileIterator;
import practice.behavioral_pattern.state_pattern.context.GumballMachine;
import practice.behavioral_pattern.template_method_pattern.FacebookNetwork;
import practice.behavioral_pattern.template_method_pattern.TwitterNetwork;
import practice.behavioral_pattern.template_method_pattern.WhatsappNetwork;
import practice.structural_pattern.adapter_pattern.JsonToXmlAdapter;
import practice.structural_pattern.adapter_pattern.WebClient;
import practice.structural_pattern.adapter_pattern.adaptee.JsonClass;
import practice.structural_pattern.adapter_pattern.client_interface.ClientObject;
import practice.structural_pattern.adapter_pattern.client_interface.XmlClass;
import practice.structural_pattern.decorator_pattern.base.Farmhouse;
import practice.structural_pattern.decorator_pattern.base.PizzaComponent;
import practice.structural_pattern.decorator_pattern.decorator.Cheese;
import practice.creational_patterm.factory_pattern.*;
import practice.behavioral_pattern.observer_pattern.*;
import practice.behavioral_pattern.observer_pattern.weather_publisher.EuropeWeatherPublisher;
import practice.behavioral_pattern.observer_pattern.weather_publisher.WeatherPublisher;
import practice.behavioral_pattern.observer_pattern.weather_publisher.AsiaWeatherPublisher;
import practice.behavioral_pattern.strategy_pattern.StrategyConstructor;
import practice.behavioral_pattern.strategy_pattern.vehicle.Vehicle;
import practice.creational_patterm.prototype_pattern.Sapling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);

        System.out.println("\n ---- running ------\n");

        /** Behavioral Design Pattern Test */
        System.out.println("\n ---- running strategy pattern ------\n");
        strategyPatterRun();
        System.out.println("\n ---- running observer pattern ------\n");
        observerPatterRun();
        System.out.println("\n ---- running command pattern ------\n");
        commandPatternRun();
        System.out.println("\n ---- running template pattern ------\n");
        templatePatternRun();
        System.out.println("\n ---- running iterator pattern ------\n");
        iteratorPatternRun();
        System.out.println("\n ---- running State pattern ------\n");
        statePatternRun();

        /** Structural Design Pattern Test */
        System.out.println("\n ---- running decorator pattern ------\n");
        decoratorPattern();
        System.out.println("\n ---- running adapter pattern ------\n");
        adapterPatternRun();



        /** Creational Design Pattern Test */
        System.out.println("\n ---- running factory pattern ------\n");
        factoryPatternRun();
        System.out.println("\n ---- running prototype pattern ------\n");
        prototypePattern();


    }

    public static void statePatternRun() {

        GumballMachine gumballMachine = new GumballMachine(5);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.printState();

        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.printState();

        gumballMachine.ejectQuarter();
        gumballMachine.printState();

        gumballMachine.turnCrank();
        gumballMachine.printState();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.turnCrank();
        gumballMachine.printState();

    }

    public static void iteratorPatternRun() {
        List<Profile> data = new ArrayList<Profile>();
        data.add(new Profile("Adarsh","mail1@gmail.com","Male","Y"));
        data.add(new Profile("Random1","mail1@gmail.com","Female","Y"));
        data.add(new Profile("Random2","mail1@gmail.com","Female","N"));
        data.add(new Profile("Random3","mail1@gmail.com","Male","N"));
        data.add(new Profile("Random4","mail1@gmail.com","Male","Y"));

        SocialNetwork facebook = new Facebook(data);
        SocialNetwork linkedin = new Linkedin(data);

        ProfileIterator profileIterator = facebook.createIterator();
        while (profileIterator.hasNext()) {
            System.out.println(" Facebook Profile : " + profileIterator.getNext().getUsername());
        }

        profileIterator = linkedin.createIterator();
        while (profileIterator.hasNext()) {
            System.out.println(" Linkedin Profile : " + profileIterator.getNext().getUsername());
        }
    }
    public static void commandPatternRun() {

        Controller controller;

        Light light = new Light();
        // Run Light On Commands
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        controller = new Controller(lightOnCommand);
        controller.executeCommand();

        // Run Light Off Commands
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        controller = new Controller(lightOffCommand);
        controller.executeCommand();

        // Run Custom Command with Light On and Fan Switch off only
        Fan fan = new Fan();
        FanOffCommand fanOffCommand = new FanOffCommand(fan);
        List<Command> commandList = new ArrayList<>();
        commandList.add(lightOnCommand);
        commandList.add(fanOffCommand);

        for(Command command : commandList) {
            controller = new Controller(command);
            controller.executeCommand();
        }




    }

    public static void templatePatternRun() {
        FacebookNetwork facebookNetwork = new FacebookNetwork("Adarsh","1234");
        facebookNetwork.post("Hello World");
        System.out.println();

        WhatsappNetwork whatsappNetwork = new WhatsappNetwork("Adarsh","1234");
        whatsappNetwork.post("Hello from whatsapp");
        whatsappNetwork.post("Hi");
        System.out.println();

        TwitterNetwork twitterNetwork = new TwitterNetwork("Adarsh","1234");
        twitterNetwork.post("Hello from twitter");
        System.out.println();
    }

    public static void strategyPatterRun() {
        StrategyConstructor strategyConstructor = new StrategyConstructor();
        Vehicle vehicle = new Vehicle();
        vehicle.printDriveStrategy(strategyConstructor.getStrategy("SIMPLE"));

        Vehicle vehicle1 = new Vehicle();
        vehicle1.printDriveStrategy(strategyConstructor.getStrategy("COMPLEX"));
    }

    public static void observerPatterRun() {

        WeatherPublisher publisher = new AsiaWeatherPublisher();
        WeatherPublisher publisher1 = new EuropeWeatherPublisher();

        Consumer tvConsumer = new TVConsumer();
        publisher.add(tvConsumer);
        publisher1.add(tvConsumer);

        Consumer mobileConsumer = new MobileConsumer();
        publisher.add(mobileConsumer);


        publisher.setData(42);
        publisher1.setData(34);

    }

    public static void decoratorPattern() {

        // Prepare Farmhouse Pizza with Extra cheese and Extra Veggies
        PizzaComponent pizzaComponent = new Farmhouse();
        pizzaComponent = new Cheese(pizzaComponent);

        System.out.println("Cost for " + pizzaComponent.getDescription() + " is = " + pizzaComponent.getCost());
    }


    public static void adapterPatternRun() {
        ClientObject clientObject = new XmlClass();
        WebClient webClient = new WebClient(clientObject);
        System.out.println(webClient.getValueOfObject("Adarsh"));

        JsonClass jsonClass = new JsonClass();
        JsonToXmlAdapter jsonToXmlAdapter = new JsonToXmlAdapter(jsonClass);

        webClient = new WebClient(jsonToXmlAdapter);
        System.out.println(webClient.getValueOfObject("Adarsh"));

    }

    public static void factoryPatternRun() throws Exception {

        String input = "CIRCLE";

        ShapeFactory shapeFactory;
        if(input.equals("CIRCLE"))
            shapeFactory = new CircleShapeFactory();
        else if(input.equals("TRIANGLE"))
            shapeFactory = new TriangleShapeFactory();
        else
            throw new Exception("Invalid Type");

        Shape shape = shapeFactory.create();
        shape.draw();
    }


    public static void prototypePattern() {

        Sapling sapling = new Sapling(10,20,"GREEN");
        sapling.setPosition(2,3);

        List<Sapling> shapeList = new ArrayList<>();
        shapeList.add(sapling);
        IntStream.range(0, 2).forEach(i -> {
            Sapling sapling1 = (Sapling) sapling.clone();
            sapling1.setPosition(i + 1, i + 2);
            shapeList.add(sapling1);
        });

        IntStream.range(0, shapeList.size()).mapToObj(i -> " Sapling Object " + (i + 1) + " = " + shapeList.get(i).toString()).forEach(System.out::println);
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
