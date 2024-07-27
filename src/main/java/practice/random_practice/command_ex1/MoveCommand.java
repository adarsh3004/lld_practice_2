package practice.random_practice.command_ex1;

import practice.random_practice.random_ex.Player;

public class MoveCommand implements Command{

    private Player player;

    public MoveCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.p1();
    }
}
