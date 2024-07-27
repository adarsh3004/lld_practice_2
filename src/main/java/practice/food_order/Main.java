package practice.food_order;

import practice.food_order.dao.CustomerDao;
import practice.food_order.dao.OrderDao;
import practice.food_order.dao.RestaurantDao;
import practice.food_order.service.CustomerService;
import practice.food_order.service.MenuService;
import practice.food_order.service.OrderService;
import practice.food_order.service.RestaurantService;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // Initialise Daos
        RestaurantDao restaurantDao = new RestaurantDao();
        CustomerDao customerDao = new CustomerDao();
        OrderDao orderDao = new OrderDao();

        // Initialise Service
        MenuService menuService = new MenuService();
        CustomerService customerService = new CustomerService(customerDao);
        RestaurantService restaurantService = new RestaurantService(restaurantDao,menuService);
        OrderService orderService = new OrderService(orderDao,customerService);

        // Ip1 :
        HashMap<String,Double> items = new HashMap<>();
        items.put("king_burger",10.0);
        items.put("samosa_pizza",20.0);
        items.put("alu_pasta",19.0);
        restaurantService.createRestaurant("resta1",items,15L);

        // Ip1 :
        items = new HashMap<>();
        items.put("bendi_macaroni",12.00);
        items.put("samosa_pizza",25.00);
        items.put("alu_pasta",17.00);
        restaurantService.createRestaurant("resta2",items,12L);

        // Ip3:
        items = new HashMap<>();
        items.put("bendi_macaroni",8.00);
        items.put("king_burger",15.00);
        restaurantService.updateMenu("resta1",items);

        // op1:
        System.out.println("OP1 : " + restaurantService.print());

        //Ip 4:
        HashMap<String,Long> orders = new HashMap<>();
        orders.put("bendi_macaroni",3L);
        orders.put("samosa_pizza",2L);
        orderService.createOrder(1L,"cust1",orders);

        // op2:
        System.out.println("OP2 : " + restaurantService.print());

        // op3:
        System.out.println("OP3 : " + orderService.printOrderDetails());

        //ip 5:
        orderService.markOrderAsDeilevred(1L);

        // op4:
        System.out.println("OP4 : " + restaurantService.print());

    }
}
