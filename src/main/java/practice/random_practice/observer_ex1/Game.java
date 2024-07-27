package practice.random_practice.observer_ex1;

import java.util.List;

public class Game {

    List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
    }

    void notifyPlayers(String message) {
        for (Player player : players)
            player.update(message);
    }
}
