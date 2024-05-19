package practice.event_calendar.model.team_addition_strategy.factory;


import practice.event_calendar.exception.InvalidInputException;
import practice.event_calendar.model.team_addition_strategy.FirstNUsersAddition;
import practice.event_calendar.model.team_addition_strategy.TeamAddition;

public class TeamAdditionStrategyFactory {

    public TeamAddition getStrategy(String key) throws InvalidInputException {
        if(key.isEmpty())
            throw new InvalidInputException("Invalid key for Team Addition Strategy");
        if(key.equals("FIRST_N"))
            return new FirstNUsersAddition();
        throw new InvalidInputException("Invalid key for Team Addition Strategy");
    }
}
