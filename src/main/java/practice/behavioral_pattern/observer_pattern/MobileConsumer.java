package practice.behavioral_pattern.observer_pattern;

import practice.behavioral_pattern.observer_pattern.riot_news_publisher.RiotScorePublisher;
import practice.behavioral_pattern.observer_pattern.weather_publisher.WeatherPublisher;

public class MobileConsumer implements Consumer {


    @Override
    public void update(WeatherPublisher weatherPublisher) {
        System.out.println("...... Mobile Consumer Got Update Message ::   ......" + weatherPublisher.getData());
    }

    @Override
    public void update(RiotScorePublisher riotScorePublisher) {

    }
}
