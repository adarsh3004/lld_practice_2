package practice.food_order.service;

import practice.food_order.dao.RestaurantDao;
import practice.food_order.model.Item;
import practice.food_order.model.Menu;
import practice.food_order.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService {

    private RestaurantDao restaurantDao;
    private MenuService menuService;

    public RestaurantService(RestaurantDao restaurantDao,MenuService menuService) {
        this.restaurantDao = restaurantDao;
        this.menuService = menuService;
    }

    public void createRestaurant(String restaurantName, HashMap<String,Double> itemPriceMap, Long maxCapacity) {
        List<Item> itemList = new ArrayList<>();
        itemPriceMap.forEach((key, value) -> itemList.add(new Item(key, value)));

        Menu menu = menuService.createMenu(restaurantName+"_Menu",itemList);
        Restaurant restaurant = new Restaurant(restaurantName,maxCapacity,menu);
        restaurantDao.addRestaurant(restaurant);
    }

    public  void updateMenu(String restaurantName, HashMap<String,Double> itemPriceMap) {
        System.out.println(restaurantDao.getRestaurantHashMap());
        List<Item> itemList = new ArrayList<>();
        itemPriceMap.forEach((key, value) -> itemList.add(new Item(key, value)));

        Restaurant restaurant = restaurantDao.getRestaurant(restaurantName);
        System.out.println(restaurant);
        restaurant.setMenu(menuService.updateMenu(restaurant.getMenu(),itemList));
        restaurantDao.addRestaurant(restaurant);
    }


    public String print() {
        HashMap<String, Restaurant> restaurantHashMap = restaurantDao.getRestaurantHashMap();
        StringBuilder str = new StringBuilder();
        for(Map.Entry<String, Restaurant> entry : restaurantHashMap.entrySet()) {
            str.append(entry.getKey() + " :: " + entry.getValue());
            str.append("\n");
        }
        return str.toString();
    }

}
