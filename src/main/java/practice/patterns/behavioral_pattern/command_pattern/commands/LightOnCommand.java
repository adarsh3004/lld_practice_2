package practice.patterns.behavioral_pattern.command_pattern.commands;

import practice.patterns.behavioral_pattern.command_pattern.receiver.Light;

public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.on();
    }
}
