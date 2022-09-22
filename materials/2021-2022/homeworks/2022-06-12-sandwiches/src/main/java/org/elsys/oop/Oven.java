package org.elsys.oop;

import java.util.LinkedList;
import java.util.List;

public class Oven implements Runnable {
    List<Order> completeOrders = new LinkedList<>();
    private Order currOrder = null;
    private Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    private void log(String msg) {
        System.out.println("[Oven " + Thread.currentThread().getName() + "] " + msg);
    }

    synchronized public void setOrder(Order order) {
        currOrder = order;
        notify();
    }

    @Override
    public void run() {
        log("Has started");
        try {
            while (true) {
                log("Is waiting for order");
                synchronized (this) {
                    wait();
                }

                log("Starts baking order #" + currOrder.getId());
                Thread.sleep(Order.bakeTIme);

                log("Finished baking order #" + currOrder.getId());
                currOrder.isBaked = true;
                completeOrders.add(currOrder);
                currOrder = null;

                restaurant.addFreeOven(this);
            }
        } catch (InterruptedException ex) {
            log("Shutdown");
        }
    }
}
