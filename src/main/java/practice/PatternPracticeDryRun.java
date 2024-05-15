package practice;

import practice.patterns.behavioral_pattern.command_pattern.Controller;
import practice.patterns.behavioral_pattern.command_pattern.commands.Command;
import practice.patterns.behavioral_pattern.command_pattern.commands.FanOffCommand;
import practice.patterns.behavioral_pattern.command_pattern.commands.LightOffCommand;
import practice.patterns.behavioral_pattern.command_pattern.commands.LightOnCommand;
import practice.patterns.behavioral_pattern.command_pattern.receiver.Fan;
import practice.patterns.behavioral_pattern.command_pattern.receiver.Light;
import practice.patterns.behavioral_pattern.iterator_pattern.Profile;
import practice.patterns.behavioral_pattern.iterator_pattern.aggregate.Facebook;
import practice.patterns.behavioral_pattern.iterator_pattern.aggregate.Linkedin;
import practice.patterns.behavioral_pattern.iterator_pattern.aggregate.SocialNetwork;
import practice.patterns.behavioral_pattern.iterator_pattern.iterator.ProfileIterator;
import practice.patterns.behavioral_pattern.observer_pattern.Consumer;
import practice.patterns.behavioral_pattern.observer_pattern.MobileConsumer;
import practice.patterns.behavioral_pattern.observer_pattern.TVConsumer;
import practice.patterns.behavioral_pattern.observer_pattern.weather_publisher.AsiaWeatherPublisher;
import practice.patterns.behavioral_pattern.observer_pattern.weather_publisher.EuropeWeatherPublisher;
import practice.patterns.behavioral_pattern.observer_pattern.weather_publisher.WeatherPublisher;
import practice.patterns.behavioral_pattern.state_pattern.context.GumballMachine;
import practice.patterns.behavioral_pattern.strategy_pattern.StrategyConstructor;
import practice.patterns.behavioral_pattern.strategy_pattern.vehicle.Vehicle;
import practice.patterns.behavioral_pattern.template_method_pattern.FacebookNetwork;
import practice.patterns.behavioral_pattern.template_method_pattern.TwitterNetwork;
import practice.patterns.behavioral_pattern.template_method_pattern.WhatsappNetwork;
import practice.patterns.creational_patterm.factory_pattern.CircleShapeFactory;
import practice.patterns.creational_patterm.factory_pattern.Shape;
import practice.patterns.creational_patterm.factory_pattern.ShapeFactory;
import practice.patterns.creational_patterm.factory_pattern.TriangleShapeFactory;
import practice.patterns.creational_patterm.prototype_pattern.Sapling;
import practice.patterns.structural_pattern.adapter_pattern.JsonToXmlAdapter;
import practice.patterns.structural_pattern.adapter_pattern.WebClient;
import practice.patterns.structural_pattern.adapter_pattern.adaptee.JsonClass;
import practice.patterns.structural_pattern.adapter_pattern.client_interface.ClientObject;
import practice.patterns.structural_pattern.adapter_pattern.client_interface.XmlClass;
import practice.patterns.structural_pattern.decorator_pattern.base.Farmhouse;
import practice.patterns.structural_pattern.decorator_pattern.base.PizzaComponent;
import practice.patterns.structural_pattern.decorator_pattern.decorator.Cheese;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PatternPracticeDryRun {

    public void run() throws Exception {
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

    private void statePatternRun() {

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

    private void iteratorPatternRun() {
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
    private void commandPatternRun() {

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

    private void templatePatternRun() {
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

    private void strategyPatterRun() {
        StrategyConstructor strategyConstructor = new StrategyConstructor();
        Vehicle vehicle = new Vehicle();
        vehicle.printDriveStrategy(strategyConstructor.getStrategy("SIMPLE"));

        Vehicle vehicle1 = new Vehicle();
        vehicle1.printDriveStrategy(strategyConstructor.getStrategy("COMPLEX"));
    }

    private void observerPatterRun() {

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

    private void decoratorPattern() {

        // Prepare Farmhouse Pizza with Extra cheese and Extra Veggies
        PizzaComponent pizzaComponent = new Farmhouse();
        pizzaComponent = new Cheese(pizzaComponent);

        System.out.println("Cost for " + pizzaComponent.getDescription() + " is = " + pizzaComponent.getCost());
    }


    private void adapterPatternRun() {
        ClientObject clientObject = new XmlClass();
        WebClient webClient = new WebClient(clientObject);
        System.out.println(webClient.getValueOfObject("Adarsh"));

        JsonClass jsonClass = new JsonClass();
        JsonToXmlAdapter jsonToXmlAdapter = new JsonToXmlAdapter(jsonClass);

        webClient = new WebClient(jsonToXmlAdapter);
        System.out.println(webClient.getValueOfObject("Adarsh"));

    }

    private void factoryPatternRun() throws Exception {

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


    private void prototypePattern() {

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
}
