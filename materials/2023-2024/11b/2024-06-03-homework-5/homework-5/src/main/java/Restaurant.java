import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurant {
    private final Queue<Order> orders = new LinkedList<>();
    private List<Order> allOrders = new LinkedList<>();

    public void addOrder(Order order) {
        synchronized (orders) {
            orders.add(order);
            allOrders.add(order);

            orders.notify();
        }
    }

    public void finalizeOrder(Order order) throws Exception {
        synchronized (orders) {
            if(allOrders
                    .stream()
                    .noneMatch((o) -> o.getId() == order.getId())
//                    .anyMatch((o) -> o.getId() == order.getId())
            ) {
                throw new Exception("Invalid order");
            }

            System.out.println("Order " + order.getId() + " ready");
            allOrders = allOrders
                    .stream()
                    .filter((o) -> o.getId() != order.getId())
                    .toList();

//            allOrders.remove(allOrders.indexOf(order));
        }
    }

    public Queue<Order> getOrders() {
        return orders;
    }
}
