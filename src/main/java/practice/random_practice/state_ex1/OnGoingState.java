package practice.random_practice.state_ex1;

public class OnGoingState implements EventState{

    @Override
    public void startEvent(Event event) {
        System.out.println("FAILURE : Cant start ongoing event");
    }

    @Override
    public void editEvent(Event event) {
        System.out.println("FAILURE : Cant edit ongoing event");
    }

    @Override
    public void deleteEvent(Event event) {
        System.out.println("FAILURE : Cant delete ongoing event");
    }
}
