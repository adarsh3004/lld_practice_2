package practice.patterns.behavioral_pattern.observer_pattern;

import practice.patterns.behavioral_pattern.observer_pattern.riot_news_publisher.RiotScorePublisher;
import practice.patterns.behavioral_pattern.observer_pattern.weather_publisher.WeatherPublisher;

public class TVConsumer implements Consumer {

    @Override
    public void update(WeatherPublisher weatherPublisher) {
        System.out.println("...... TV Consumer Got Update Message ::   ......" + weatherPublisher.getData());
    }

    @Override
    public void update(RiotScorePublisher riotScorePublisher) {
        System.out.println("...... TV Consumer Got Update Message ::   ......" + riotScorePublisher.getData());
    }
}
