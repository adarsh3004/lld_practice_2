package practice.random_practice.command_ex1;

import practice.random_practice.random_ex.Player;

public class Test {

    public static void main(String[] args) {

        Command c = new MoveCommand(new Player());
        c.execute();
    }
}
