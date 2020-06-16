package org.elsys.duzunov;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Supermarket implements CashDesk {
    private static final int INIT_DESKS = 20;
    private static final int MAX_DESKS = 20;
    private static final int MAX_DELAY = 500;
    private static final int MIN_DELAY = 100;

    private final ArrayBlockingQueue<CashDesk> cashDesks =
            new ArrayBlockingQueue<>(MAX_DESKS);
    private final AtomicInteger delay = new AtomicInteger();
    private final AtomicLong amountBits =
            new AtomicLong(Double.doubleToLongBits(0));

    public Supermarket() {
        for (int i = 0; i < INIT_DESKS; ++i) {
            cashDesks.add(new SingleCashDesk());
        }
    }

    @Override
    public void serveCustomer(Customer customer) {
        try {
            delay.addAndGet(customer.getServiceTime());

            CashDesk cashDesk = null;
            if (delay.get() > MAX_DELAY && cashDesks.size() < MAX_DESKS) {
                cashDesk = new SingleCashDesk();
            } else {
                cashDesk = cashDesks.take();
            }

            cashDesk.serveCustomer(customer);
            amountBits.updateAndGet(
                    currentValue -> Double.doubleToLongBits(
                            Double.longBitsToDouble(currentValue) +
                                    customer.getTotalPrice()
                    )
            );

            if (delay.get() >= MIN_DELAY || cashDesks.size() == 0) {
                cashDesks.add(cashDesk);
            }

            delay.addAndGet(-customer.getServiceTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getAmount() {
        return Double.longBitsToDouble(amountBits.get());
    }

    @Override
    public void setAmount(double amount) {
        this.amountBits.set(Double.doubleToLongBits(amount));
    }
}
