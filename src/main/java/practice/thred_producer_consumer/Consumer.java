package practice.thred_producer_consumer;

public class Consumer implements Runnable{

    private Inventory inventory;
    private int mx = 10;

    public Consumer(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while(true) {
            mx--;
            synchronized (inventory.getLock()) {
                while(inventory.getInventorySize() == 0) {
                    try {
                        inventory.getLock().wait();
                    }catch (InterruptedException it) {
                        Thread.currentThread().interrupt();
                    }
                }
                int item = Math.toIntExact(inventory.getItem());
                System.out.println("Item fetched : " +item + " and inventory size is " + inventory.getInventorySize());
                inventory.getLock().notifyAll();
            }
            if(mx < 0)
                break;
        }
    }
}
