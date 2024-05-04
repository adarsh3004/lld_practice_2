package practice.behavioral_pattern.observer_pattern.weather_publisher;

import practice.behavioral_pattern.observer_pattern.Consumer;

import java.util.ArrayList;
import java.util.List;

public class EuropeWeatherPublisher implements WeatherPublisher{

    private List<Consumer> consumerList;
    private int temp;

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
    public void setData(int temp) {
        this.temp = temp;
        if(temp > 30)
            notifyFun();
    }

    public String getData() {
        return "Alert : Current Temperature of Europe is more than " + this.temp;
    }
}
