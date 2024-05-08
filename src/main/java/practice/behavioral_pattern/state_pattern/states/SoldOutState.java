package practice.behavioral_pattern.state_pattern.states;

import practice.behavioral_pattern.state_pattern.context.GumballMachine;

public class SoldOutState implements State{
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("ERROR :: Can't insert a quarter. Machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("ERROR :: there is no quarter.....");
    }

    @Override
    public void turnCrank() {
        System.out.println("ERROR :: there is no gumball.....");
    }

    @Override
    public void dispense() {
        System.out.println("ERROR :: there is no gumball.....");
    }
}