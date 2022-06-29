package org.elsys.oop;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {
    private final List<Cook> cooks = new LinkedList<>();

    private final Queue<Order> orders = new PriorityQueue<>();
    private final List<Oven> ovens = new LinkedList<>();
    private final Queue<Oven> freeOvens = new ArrayDeque<>();

    private final ExecutorService cooksPool = Executors.newCachedThreadPool();
    private final ExecutorService ovensPool = Executors.newCachedThreadPool();

    final Lock ovensLock = new ReentrantLock();
    final Lock ordersLock = new ReentrantLock();

    public void addCook(Cook cook) {
        System.out.println("Add cook " + cook.getName() + " to the restaurant");
        cook.setRestaurant(this);
        cooks.add(cook);
        cooksPool.submit(cook);
    }

    public void addOrder(Order order) {
        if (!order.isValid()) throw new IllegalArgumentException("Order is not valid");

        synchronized (ordersLock) {
            System.out.println("Receive new order #" + order.getId());
            orders.add(order);
            System.out.println("Inform cooks");
            ordersLock.notify();
        }
    }

    public void addOven(Oven oven) {
        oven.setRestaurant(this);
        ovens.add(oven);
        addFreeOven(oven);
        ovensPool.submit(oven);
    }

    public Order getNextOrder() throws NoSuchElementException {
        synchronized (ordersLock) {
            return orders.remove();
        }
    }

    public void addFreeOven(Oven oven) {
        synchronized (ovensLock) {
            System.out.println("An oven is free for work");
            freeOvens.add(oven);
            System.out.println("Inform cooks");
            ovensLock.notify();
        }
    }

    public Oven getNextOven() throws NoSuchElementException {
        synchronized (ovensLock) {
            return freeOvens.remove();
        }
    }

    public List<Oven> getAllOvens() {
        return ovens;
    }

    public void finalizeOrder(Order order) {
        System.out.println("Order #" + order.getId() + " is complete");
    }

    public void shutdown() {
        System.out.println("Clear pending orders");
        synchronized (ordersLock) {
            orders.clear();
        }

        System.out.println("Stop the cooks");
        cooksPool.shutdownNow();
        try {
            cooksPool.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stop the ovens");
        ovensPool.shutdownNow();
    }
}
