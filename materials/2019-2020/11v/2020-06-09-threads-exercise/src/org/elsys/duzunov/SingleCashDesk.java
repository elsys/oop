package org.elsys.duzunov;

public class SingleCashDesk implements CashDesk {
    private static final int MAX_CASH = 100;

    private double amount = 0;

    @Override
    public synchronized void serveCustomer(Customer customer) {
        setAmount(getAmount() + customer.buyGoods());
    }

    @Override
    public synchronized double getAmount() {
        return amount;
    }

    @Override
    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }
}
