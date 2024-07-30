package practice.thred_producer_consumer;

public class Test {

    public static void main(String[] args) {
        Inventory inv = new Inventory();

       Thread p = new Thread(new Producer(inv));
       Thread c = new Thread(new Consumer(inv));

       p.start();
       c.start();
    }
}
