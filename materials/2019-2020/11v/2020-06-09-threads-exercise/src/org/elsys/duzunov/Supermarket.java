package org.elsys.duzunov;

import java.util.concurrent.ArrayBlockingQueue;

public class Supermarket implements CashDesk {
    private static final int MAX_DESKS = 20;
    private static final int MAX_DELAY = 500;
    private static final int MIN_DELAY = 100;

    private final ArrayBlockingQueue<CashDesk> cashDesks =
            new ArrayBlockingQueue<>(MAX_DESKS);
    private double amount = 0;

    public Supermarket() {
        for (int i = 0; i < MAX_DESKS; ++i) {
            cashDesks.add(new SingleCashDesk());
        }
    }

    @Override
    public void serveCustomer(Customer customer) {
        try {
            CashDesk cashDesk = cashDesks.take();
            cashDesk.serveCustomer(customer);
            synchronized (this) {
                setAmount(getAmount() + customer.getTotalPrice());
            }
            cashDesks.put(cashDesk);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
