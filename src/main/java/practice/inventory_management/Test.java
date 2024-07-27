package practice.inventory_management;

import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        Inventory inventory = new Inventory();
        inventory.addItem("Biscuit",100L);
        inventory.addItem("Chips",200L);



        Order order = new Order(inventory,"Biscuit",100L);
        order.placeOrder();

        Order order1 = new Order(inventory,"Biscuit",100L);
        order1.placeOrder();

        System.out.println(LocalDateTime.now() + " : Waiting for 12 Secs");
        Thread.sleep(12000);

        Order order2 = new Order(inventory,"Biscuit",100L);
        order2.placeOrder();
    }
}
