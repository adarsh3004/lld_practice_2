package practice.patterns.behavioral_pattern.state_pattern.states;

import practice.patterns.behavioral_pattern.state_pattern.context.GumballMachine;

public class HasQuarterState implements State {

    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("ERROR :: Already there is a quarter.....");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("SUCCESS :: Take your Quarter");
        gumballMachine.setState(new NoQuarterState(gumballMachine));
    }

    @Override
    public void turnCrank() {
        System.out.println("SUCCESS :: Turning Crank");
        gumballMachine.setState(new SoldState(gumballMachine));
    }

    @Override
    public void dispense() {
        System.out.println("ERROR :: Please turn the crank");
    }
}