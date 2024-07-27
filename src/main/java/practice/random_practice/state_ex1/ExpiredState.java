package practice.random_practice.state_ex1;

public class ExpiredState implements EventState{

    @Override
    public void startEvent(Event event) {
        System.out.println("FAILURE : Cant start deleted event");
    }

    @Override
    public void editEvent(Event event) {
        System.out.println("FAILURE : Cant edit deleted event");
    }

    @Override
    public void deleteEvent(Event event) {
        System.out.println("SUCCESS : Deleting event");
        event.setEventState(new ExpiredState());
    }
}
