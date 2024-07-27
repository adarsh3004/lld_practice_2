package practice.food_order.dao;

import practice.food_order.model.Customer;

import java.util.HashMap;

public class CustomerDao {

    private HashMap<String, Customer> customerHashMap;

    public CustomerDao(){
        this.customerHashMap = new HashMap<>();
    }

    public void addCustomer(String name, Customer customer) {
        this.customerHashMap.put(name,customer);
    }

    public Customer getCustomer(String name) {
        if(this.customerHashMap.containsKey(name))
            this.customerHashMap.get(name);
        return null; //TODO : exception
    }
}
