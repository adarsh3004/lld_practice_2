package practice.food_order.service;

import practice.food_order.dao.CustomerDao;
import practice.food_order.model.Customer;

public class CustomerService {

    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer createCustomer(String name, String address, String number) {
        Customer customer = new Customer(name,address,number);
        return customer;
    }

    public Customer getCustomer(String name) {
        return customerDao.getCustomer(name);
    }

}
