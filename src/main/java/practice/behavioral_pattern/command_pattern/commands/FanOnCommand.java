package practice.behavioral_pattern.command_pattern.commands;

import practice.behavioral_pattern.command_pattern.receiver.Fan;

public class FanOnCommand implements Command{

    Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }
}
