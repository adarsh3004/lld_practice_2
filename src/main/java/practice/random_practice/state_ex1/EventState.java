package practice.random_practice.state_ex1;

public interface EventState {

    void startEvent(Event event);
    void editEvent(Event event);
    void deleteEvent(Event event);
}
