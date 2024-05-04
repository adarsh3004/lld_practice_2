package practice.behavioral_pattern.command_pattern.receiver;

public class Fan {

    public Fan(){}

    public void on() {
        System.out.println("Switching on Fan");
    }

    public void off() {
        System.out.println("Switching off Fan");
    }
}
