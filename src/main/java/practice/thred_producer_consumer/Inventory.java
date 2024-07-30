package practice.thred_producer_consumer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Inventory {

    private Queue<Long> queue;
    private Object lock;
    private Long maxInventorySize;

    public Inventory() {
        queue = new LinkedList<>();
        lock = new Object();
        maxInventorySize = 2L;
    }

    public Long getItem() {
        if(Objects.nonNull(queue)) {
            return queue.poll();
        }
        return null;
    }

    public void addItem(Long val) {
        queue.add(val);
    }

    public int getInventorySize() {
        return this.queue.size();
    }

    public Object getLock() {
        return this.lock;
    }

    public Long getMaxInventorySize() {
        return this.maxInventorySize;
    }
}
