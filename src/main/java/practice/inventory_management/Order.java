package practice.inventory_management;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Order {

    private Inventory inventory;
    private String item;
    private Long quantity;
    private static final Long BLOCK_DURATION = 3000L; // 3 secs


    public Order(Inventory inventory, String item, Long quantity) {
        this.inventory = inventory;
        this.item = item;
        this.quantity = quantity;
    }

    public boolean placeOrder() {
        System.out.println(LocalDateTime.now() + " : Ordering : " + quantity + " "+ item);
        boolean success = inventory.blockItem(item,quantity);

        if(success) {
            System.out.println(LocalDateTime.now() + " : Ordering SUCCESSFUL For : " + quantity + " "+ item);
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(LocalDateTime.now() + " : Releasing : " + quantity + " "+ item);
                    inventory.releaseItem(item,quantity);
                }
            },BLOCK_DURATION);
        }
        else {
            System.out.println(LocalDateTime.now() + " : Ordering FAILED For : " + quantity + " "+ item);
        }
        return success;
    }
}
