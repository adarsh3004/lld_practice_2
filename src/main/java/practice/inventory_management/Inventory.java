package practice.inventory_management;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String,Long> stock;
    private Map<String,Long> blockedStock;

    public Inventory() {
        this.stock =  new HashMap<>();
        this.blockedStock = new HashMap<>();
    }

    public synchronized boolean blockItem(String item, Long quantity) {
        Long available = stock.getOrDefault(item,0L);

        if(quantity <= available) {
            stock.put(item,available-quantity);
            blockedStock.put(item,blockedStock.getOrDefault(item,0L) + quantity);
            return true;
        }
        return false;
    }

    public synchronized boolean releaseItem(String item,Long quantity) {
        Long available = blockedStock.getOrDefault(item,0L);

        if(quantity <= available) {
            blockedStock.put(item,available-quantity);
            stock.put(item,stock.getOrDefault(item,0L) + quantity);
        }
        return false;
    }


    public synchronized void addItem(String item, Long quantity) {
        stock.put(item, stock.getOrDefault(item, 0L) + quantity);
    }

    public synchronized Long getStock(String item) {
        return stock.getOrDefault(item, 0L);
    }

    public synchronized Long getBlockedStock(String item) {
        return blockedStock.getOrDefault(item, 0L);
    }


}
