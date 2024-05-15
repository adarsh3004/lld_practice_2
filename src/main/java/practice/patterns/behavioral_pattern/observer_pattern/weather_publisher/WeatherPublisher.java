package practice.patterns.behavioral_pattern.observer_pattern.weather_publisher;

import practice.patterns.behavioral_pattern.observer_pattern.Consumer;

public interface WeatherPublisher {

    void add(Consumer consumer);

    void remove(Consumer consumer);

    void notifyFun();

    void setData(int temp);

    String getData();
}
