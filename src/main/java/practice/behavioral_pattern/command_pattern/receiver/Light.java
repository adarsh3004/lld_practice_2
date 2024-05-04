package practice.behavioral_pattern.command_pattern.receiver;

public class Light {

    public Light() {}

    public void on() {
        System.out.println("Switching on Light");
    }

    public void off() {
        System.out.println("Switching off Light");
    }
}
