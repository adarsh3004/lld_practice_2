package practice.random_practice.observer_ex1;

public class Player implements Observer{

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notifying message to "  + name + " " + message);
    }
}
