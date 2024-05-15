package practice.patterns.behavioral_pattern.state_pattern.context;

import practice.patterns.behavioral_pattern.state_pattern.states.NoQuarterState;
import practice.patterns.behavioral_pattern.state_pattern.states.SoldOutState;
import practice.patterns.behavioral_pattern.state_pattern.states.State;

public class GumballMachine {

    State state;
    int count;

    public GumballMachine(int count) {
        this.count = count;
        if(count > 0)
            this.state = new NoQuarterState(this);
        else
            this.state = new SoldOutState(this);
    }


    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }


    public void ejectQuarter() {
        state.ejectQuarter();
    }


    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void printState() {
        System.out.println(this.state);
    }


}