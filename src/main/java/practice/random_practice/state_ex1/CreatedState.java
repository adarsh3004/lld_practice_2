package practice.random_practice.state_ex1;

public class CreatedState implements EventState{

    @Override
    public void startEvent(Event event) {
        System.out.println("SUCCESS : Staring Event");
        event.setEventState(new OnGoingState());
    }

    @Override
    public void editEvent(Event event) {
        System.out.println("SUCCESS : Editing Event");
    }

    @Override
    public void deleteEvent(Event event) {
        System.out.println("SUCCESS : Deleting Event");
        event.setEventState(new ExpiredState());
    }
}
