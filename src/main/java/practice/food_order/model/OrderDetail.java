package practice.food_order.model;

import lombok.ToString;

@ToString
public class OrderDetail {

    private String itemName;
    private Long quantity;
    private Restaurant restaurant;

    public OrderDetail(String itemName, Long quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItem() {
        return itemName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
