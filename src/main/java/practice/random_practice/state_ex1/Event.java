package practice.random_practice.state_ex1;

public class Event {

    EventState eventState;

    public Event() {
        this.eventState = new CreatedState();
    }

    public void setEventState(EventState eventState) {
        this.eventState = eventState;
    }

    public EventState getEventState(){
        return this.eventState;
    }


    public void startEvent() {eventState.startEvent(this);}

    public void endEvent() {
        eventState.deleteEvent(this);
    }

    public void editEvent() {
        eventState.editEvent(this);
    }
}
