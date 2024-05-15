package practice.patterns.behavioral_pattern.observer_pattern.riot_news_publisher;

import practice.patterns.behavioral_pattern.observer_pattern.Consumer;

import java.util.ArrayList;
import java.util.List;

public class AdultDeathCountPublisher implements RiotScorePublisher{

    private List<Consumer> consumerList;
    private int deathCount;

    @Override
    public void add(Consumer consumer) {
        if(this.consumerList == null)
            this.consumerList = new ArrayList<>();
        this.consumerList.add(consumer);
    }

    @Override
    public void remove(Consumer consumer) {
        this.consumerList.remove(consumer);
    }

    @Override
    public void notifyFun() {
        this.consumerList.forEach(consumer -> consumer.update(this));
    }

    @Override
    public void setDeathCount(int cnt) {
        this.deathCount = cnt;
        if(this.deathCount > 100)
            notifyFun();
    }

    @Override
    public String getData() {
        return "Bhaago";
    }
}
