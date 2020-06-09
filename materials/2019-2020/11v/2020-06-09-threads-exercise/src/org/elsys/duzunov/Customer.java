package org.elsys.duzunov;

public class Customer implements Runnable {
    private CashDesk cashDesk;
    private int serviceTime;
    private double totalPrice;

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
        throw new UnsupportedOperationException("Please implement this method");
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public void run() {
    }
}
