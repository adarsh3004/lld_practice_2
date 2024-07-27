package practice.food_order.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Order {

    private Long orderId;
    private Customer customer;
    private List<OrderDetail> orderDetails;
    private boolean isCancelled;
    private boolean isDelievered;
    private String estimatedTime;

    public Order(Long orderId, Customer customer, List<OrderDetail> orderDetails,String estimatedTime) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDetails = orderDetails;
        this.estimatedTime = estimatedTime;
        this.isDelievered = false;
        this.isCancelled = false;
    }

    public void setDelievered(boolean delievered) {
        isDelievered = delievered;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void addOrderDetails(OrderDetail orderDetail) {
        if(this.orderDetails == null)
            this.orderDetails = new ArrayList<>();
        orderDetails.add(orderDetail);
    }
}
