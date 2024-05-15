package practice.patterns.behavioral_pattern.command_pattern.commands;

import practice.patterns.behavioral_pattern.command_pattern.receiver.Fan;

public class FanOffCommand implements Command{
    Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }
}
