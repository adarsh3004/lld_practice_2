package practice.inventory_management;

import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        Inventory inventory = new Inventory();
        inventory.addItem("Biscuit",5L);
        inventory.addItem("Chips",10L);

        threadCall(inventory);
    }

    private static void normalOrderCall(Inventory inventory) throws InterruptedException {
        Order order = new Order(inventory,"Biscuit",100L);
        order.placeOrder();

        Order order1 = new Order(inventory,"Biscuit",100L);
        order1.placeOrder();

        System.out.println(LocalDateTime.now() + " : Waiting for 12 Secs");
        Thread.sleep(12000);

        Order order2 = new Order(inventory,"Biscuit",100L);
        order2.placeOrder();
    }

    private static void threadCall(Inventory inventory) throws InterruptedException {
        Runnable task = () ->  {
            Order order3 = new Order(inventory,"Biscuit",5L);
            order3.placeOrder();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);


        t1.start();
        Thread.sleep(12000);
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final stock of biscuit: " + inventory.getStock("biscuit"));
        System.out.println("Final blocked stock of biscuit: " + inventory.getBlockedStock("biscuit"));

        Thread.sleep(5000);
        new Order(inventory,"Biscuit",5L).placeOrder();
        System.out.println("Final stock of biscuit: " + inventory.getStock("biscuit"));
        System.out.println("Final blocked stock of biscuit: " + inventory.getBlockedStock("biscuit"));
    }
}
