package practice.event_calendar.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Event {

    private Long id;
    private String name;
    private Map<Long,User> users;
    private List<Team> teams;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private int representatives;

    public Event(Long id, String name, Map<Long,User> users, List<Team> teams, LocalDateTime startAt, LocalDateTime endAt, int representatives) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.teams = teams;
        this.startAt = startAt;
        this.endAt = endAt;
        this.representatives = representatives;
    }

    public Long getId() {
        return id;
    }

    public Map<Long,User> getUsers() {
        return users;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public int getRepresentatives() {
        return representatives;
    }
}
