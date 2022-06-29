package org.elsys.oop;

import java.util.List;
import java.util.NoSuchElementException;

public class Cook implements Runnable {
    private final String name;
    private Restaurant restaurant;
    private boolean pendingShutdown = false;

    public Cook(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    private void log(String msg) {
        System.out.println("[Cook " + Thread.currentThread().getName() + "] " + msg);
    }

    private Order waitAndGetNextOrder() throws InterruptedException {
        Order currOrder = null;

        while (currOrder == null) {
            log("Is checking for orders");

            synchronized (restaurant.ordersLock) {
                try {
                    currOrder = restaurant.getNextOrder();
                } catch (NoSuchElementException ex) {
                    log("Is waiting for orders");
                    restaurant.ordersLock.wait();
                    log("Woke up");
                }
            }
        }

        return currOrder;
    }

    private Oven waitAndGetNextOven() throws InterruptedException {
        Oven oven = null;

        while (oven == null) {
            log("Is checking for free ovens");

            synchronized (restaurant.ovensLock) {
                try {
                    oven = restaurant.getNextOven();
                } catch (NoSuchElementException ex) {
                    log("Is waiting for free ovens");
                    restaurant.ovensLock.wait();
                    log("Woke up");
                }
            }
        }

        return oven;
    }

    private void processIngredients(Order order) throws InterruptedException {
        List<String> ingredients = order.getPendingIngredients();

        for (String ingredient : ingredients) {
            log("Putting " + ingredient + " on order #" + order.getId());
            Thread.sleep(Order.getPlacementTime(ingredient));
        }
    }

    private void transferOrdersFromOvens() {
        log("Checking for ovens with complete orders");
        List<Oven> allOvens = restaurant.getAllOvens();
        for (Oven o : allOvens) {
            synchronized (o) {
                if (o.completeOrders.size() > 0) {
                    log("Moving complete orders");
                    for (Order oo : o.completeOrders)
                        restaurant.addOrder(oo);
                    // Empty the list
                    o.completeOrders.clear();
                    log("The oven is empty");
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        log("Has started");
        while (!pendingShutdown) {
            Order currOrder = null;

            try {
                currOrder = waitAndGetNextOrder();
            } catch (InterruptedException ex) {
                pendingShutdown = true;
            }

            log("Has taken order " + currOrder.getId());

            try {
                processIngredients(currOrder);
            } catch (InterruptedException ex) {
                pendingShutdown = true;
            }
            log("Has finished putting ingredients on order #" + currOrder.getId());

            if (!currOrder.isBaked && currOrder.needsBaking()) {
                try {
                    // Pass to the oven and forget about it if it needs to bake
                    Oven oven = waitAndGetNextOven();
                    oven.setOrder(currOrder);
                    log("Passed order #" + currOrder.getId() + " for baking");

                } catch (InterruptedException ex) {
                    pendingShutdown = true;
                }
            } else {
                // Order is ready and has to pass to the client
                log("Has prepared order " + currOrder.getId());
                restaurant.finalizeOrder(currOrder);
            }

            if (pendingShutdown) continue;

            transferOrdersFromOvens();
        }

        log("Shutdown");
    }
}
