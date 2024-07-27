package practice.random_practice.state_ex1;

public class Test {

    public static void main(String[] args) {

        Event event = new Event();
        event.startEvent();
        event.editEvent();

        Event event1 = new Event();
        event1.startEvent();
        event1.endEvent();

        Event event2 = new Event();
        event2.endEvent();

        Event event3 = new Event();
        event3.editEvent();
    }
}
