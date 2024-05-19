package practice.event_calendar.model;

import java.util.List;

public class Team {

    private Long id;
    private String name;
    private List<User> userList;

    public Team(Long id, String name, List<User> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Long getId() {
        return id;
    }
}
