package org.elsys.duzunov;

public class Vault extends Thread {
    private double amount = 0;
    private final CashDesk cashDesk;

    public Vault(CashDesk cashDesk) {
        this.setDaemon(true);
        this.cashDesk = cashDesk;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (cashDesk) {
                try {
                    cashDesk.wait();
                    amount += cashDesk.getAmount();
                    cashDesk.setAmount(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
