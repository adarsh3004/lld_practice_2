package practice.patterns.behavioral_pattern.command_pattern;

import practice.patterns.behavioral_pattern.command_pattern.commands.Command;

public class Controller {

    Command command;

    public Controller(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
