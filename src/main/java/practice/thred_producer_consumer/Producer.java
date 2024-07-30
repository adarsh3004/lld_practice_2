package practice.thred_producer_consumer;


public class Producer implements Runnable{

    private Inventory inventory;
    private int mx = 10;
    public Producer(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while(true) {
            mx--;
            synchronized (inventory.getLock()) {
                while(inventory.getInventorySize() == inventory.getMaxInventorySize()) {
                    try {
                        inventory.getLock().wait();
                    }catch (InterruptedException it) {
                        Thread.currentThread().interrupt();
                    }
                }
                int item = (int) (Math.random()*100);
                inventory.addItem((long) item);
                System.out.println("Item added : " +item + " and inventory size is " + inventory.getInventorySize());
                inventory.getLock().notifyAll();
            }
            if(mx < 0)
                break;
        }
    }
}
