package practice.behavioral_pattern.state_pattern.states;

import practice.behavioral_pattern.state_pattern.context.GumballMachine;

public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("SUCCESS :: Inserting Quarter.....");
        gumballMachine.setState(new HasQuarterState(gumballMachine));
    }

    @Override
    public void ejectQuarter() {
        System.out.println("ERROR :: No Quarter exist in machine");
    }

    @Override
    public void turnCrank() {
        System.out.println("ERROR :: Please insert Quarter");
    }

    @Override
    public void dispense() {
        System.out.println("ERROR :: Please insert Quarter");
    }
}