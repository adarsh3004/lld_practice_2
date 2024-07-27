package practice.random_practice.observer_ex1;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        Game g = new Game(Arrays.asList(new Player("adarsh"),new Player("anu"),new Player("naks")));
        g.notifyPlayers("Game cancelled");
    }
}
