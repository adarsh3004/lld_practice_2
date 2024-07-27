package practice.food_order.dao;

import practice.food_order.model.Order;

import java.util.HashMap;

public class OrderDao {
    private HashMap<Long, Order> orders;

    public OrderDao() {
        orders = new HashMap<>();
    }

    public HashMap<Long, Order> getOrders() {
        return orders;
    }

    public Order getOrderByOrderId(Long id) {
        if(orders.containsKey(id))
            return orders.get(id);
        return null; // TODO : exception
    }

    public void addOrder(Long id,Order order) {
        this.orders.put(id,order);
    }
}
