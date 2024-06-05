import java.util.Queue;

public class Cook implements Runnable {
    private String name;
    private Order order = null;
    private Restaurant restaurant;

    public Cook(String name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while(true) {
            if(Thread.interrupted()) break;

            try {
                waitAndTakeOrder();
                cookOrder();
            } catch (InterruptedException e) {
                break;
            }

            finalizeOrder();
        }
    }

    private void finalizeOrder() {
        restaurant.finalizeOrder(order);
        order = null;
    }

    private void cookOrder() throws InterruptedException {
        Thread.sleep(3000);
    }

    private void waitAndTakeOrder() throws InterruptedException {
        Queue<Order> orders = restaurant.getOrders();
        synchronized (orders) {
            if(orders.isEmpty()) {
                orders.wait();
            }
            order = orders.remove();
        }
    }
}
