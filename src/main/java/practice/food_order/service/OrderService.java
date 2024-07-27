package practice.food_order.service;

import practice.food_order.dao.OrderDao;
import practice.food_order.model.Order;
import practice.food_order.model.OrderDetail;

import java.util.*;

public class OrderService {

    private OrderDao orderDao;
    private CustomerService customerService;

    public OrderService(OrderDao orderDao,CustomerService customerService) {
        this.orderDao = orderDao;
        this.customerService = customerService;
    }

    public void createOrder(Long orderId,String customerName, HashMap<String,Long> orders) {
        Order order = new Order(orderId,customerService.getCustomer(customerName),null,null);

        for(Map.Entry<String,Long> entry : orders.entrySet()) {
            OrderDetail orderDetail = new OrderDetail(entry.getKey(),entry.getValue());
            order.addOrderDetails(orderDetail);
        }
        orderDao.addOrder(orderId, order);
    }
    public String printOrderDetails() {
        return orderDao.getOrders().toString();
    }

    public void markOrderAsDeilevred(Long orderId) {
        Order order = orderDao.getOrderByOrderId(orderId);
        order.setDelievered(true);
    }
}
