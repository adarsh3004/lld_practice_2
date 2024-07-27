package practice.food_order.dao;

import practice.food_order.model.Restaurant;

import java.util.HashMap;

public class RestaurantDao {

    private HashMap<String, Restaurant> restaurantHashMap;

    public RestaurantDao() {
        this.restaurantHashMap = new HashMap<>();
    }

    public Restaurant getRestaurant(String name) {
        if(restaurantHashMap.containsKey(name)) {
            return restaurantHashMap.get(name);
        }
        return null; // TODO exception
    }

    public HashMap<String, Restaurant> getRestaurantHashMap() {
        return restaurantHashMap;
    }

    public void addRestaurant(Restaurant restaurant) {
        if(this.restaurantHashMap == null)
            this.restaurantHashMap = new HashMap<>();
        restaurantHashMap.put(restaurant.getName(),restaurant);
    }
}
