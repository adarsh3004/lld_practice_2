package practice.behavioral_pattern.command_pattern.commands;

import practice.behavioral_pattern.command_pattern.receiver.Light;

public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.off();
    }
}
