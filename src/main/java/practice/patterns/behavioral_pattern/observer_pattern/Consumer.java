package practice.patterns.behavioral_pattern.observer_pattern;

import practice.patterns.behavioral_pattern.observer_pattern.riot_news_publisher.RiotScorePublisher;
import practice.patterns.behavioral_pattern.observer_pattern.weather_publisher.WeatherPublisher;

public interface Consumer {

    void update(WeatherPublisher weatherPublisher);

    void update(RiotScorePublisher riotScorePublisher);
}
