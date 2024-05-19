package practice.event_calendar.model;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private String name;
    private LocalDateTime occupiedFrom;
    private LocalDateTime occupiedTo;
    private Long workingHourFrom;
    private Long workingHourTo;

    public User(Long id, String name, Long workingHourFrom, Long workingHourTo) {
        this.id = id;
        this.name = name;
        this.workingHourFrom = workingHourFrom;
        this.workingHourTo = workingHourTo;
    }

    public Long getId() {
        return id;
    }

    public void setOccupiedFrom(LocalDateTime occupiedFrom) {
        this.occupiedFrom = occupiedFrom;
    }

    public void setOccupiedTo(LocalDateTime occupiedTo) {
        this.occupiedTo = occupiedTo;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getOccupiedFrom() {
        return occupiedFrom;
    }

    public LocalDateTime getOccupiedTo() {
        return occupiedTo;
    }
}
