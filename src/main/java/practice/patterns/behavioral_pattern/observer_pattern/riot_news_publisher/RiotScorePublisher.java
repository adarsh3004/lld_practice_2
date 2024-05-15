package practice.patterns.behavioral_pattern.observer_pattern.riot_news_publisher;

import practice.patterns.behavioral_pattern.observer_pattern.Consumer;

public interface RiotScorePublisher {

    void add(Consumer consumer);

    void remove(Consumer consumer);

    void notifyFun();

    void setDeathCount(int cnt);

    String getData();
}
