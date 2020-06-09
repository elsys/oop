package org.elsys.duzunov;

public class Supermarket implements CashDesk {
    private static final int MAX_DESKS = 20;
    private static final int MAX_DELAY = 500;
    private static final int MIN_DELAY = 100;

    public Supermarket() {
    }

    @Override
    public void serveCustomer(Customer customer) {
        throw new UnsupportedOperationException("Please implement this method");
    }

    @Override
    public double getAmount() {
        throw new UnsupportedOperationException("Please implement this method");
    }

    @Override
    public void setAmount(double amount) {
        throw new UnsupportedOperationException("Please implement this method");
    }
}
