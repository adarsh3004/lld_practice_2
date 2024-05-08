package practice.behavioral_pattern.state_pattern.states;

import practice.behavioral_pattern.state_pattern.context.GumballMachine;

public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("ERROR :: Hold on.. giving you a candy.....");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("ERROR :: Candy dispense already in progress.....");
    }

    @Override
    public void turnCrank() {
        System.out.println("ERROR :: Candy dispense already in progress.....");
    }

    @Override
    public void dispense() {
        if(gumballMachine.getCount() > 0) {
            System.out.println("SUCCESS ::Take your candy.....");
            gumballMachine.setCount(gumballMachine.getCount() - 1);
            if(gumballMachine.getCount() == 0)
                gumballMachine.setState(new SoldOutState(gumballMachine));
            else
                gumballMachine.setState(new NoQuarterState(gumballMachine));
        }
        else {
            System.out.println("ERROR :: No Candy.....");
            gumballMachine.setState(new SoldOutState(gumballMachine));
        }
    }
}
