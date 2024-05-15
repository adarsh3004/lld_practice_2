package practice.patterns.behavioral_pattern.state_pattern.states;

public interface State {

    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}