package org.elsys.duzunov;

import java.util.Random;

public class Snowboarder extends Thread {
    private static final Random random = new Random();

    private final CashDesk cashDesk;

    public Snowboarder(String name, CashDesk cashDesk) {
        setName(name);
        this.cashDesk = cashDesk;
    }

    @Override
    public void run() {
        cashDesk.buyCard(this);

        try {
            Thread.sleep(random.nextInt(401) + 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cashDesk.returnCard(this);
    }
}
