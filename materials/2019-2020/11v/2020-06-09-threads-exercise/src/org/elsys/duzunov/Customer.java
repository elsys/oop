package org.elsys.duzunov;

public class Customer implements Runnable {
    private final CashDesk cashDesk;
    private final int serviceTime;
    private final double totalPrice;

    public Customer(CashDesk cashDesk, int serviceTime, double totalPrice) {
        this.cashDesk = cashDesk;
        this.totalPrice = totalPrice;
        this.serviceTime = serviceTime;
    }

    /**
     * Simulates one purchase: waits a bit and returns the amount of money spent
     * (i.e. the goods price)
     */
    public double buyGoods() {
        try {
            Thread.sleep(serviceTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return getTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public void run() {
        cashDesk.serveCustomer(this);
    }
}
