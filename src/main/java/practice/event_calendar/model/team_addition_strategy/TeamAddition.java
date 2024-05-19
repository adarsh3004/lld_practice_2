package practice.event_calendar.model.team_addition_strategy;

import practice.event_calendar.model.Team;
import practice.event_calendar.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface TeamAddition {

    List<User> getUsers(Team team, LocalDateTime eventStarAt, LocalDateTime eventEndAt, Long representatives);
}
