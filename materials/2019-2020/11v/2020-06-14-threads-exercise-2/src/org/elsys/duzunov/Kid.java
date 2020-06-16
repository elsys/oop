package org.elsys.duzunov;

import java.util.Random;

public class Kid extends Thread {
    private static final Random random = new Random();

    private final Workshop workshop;

    public Kid(Workshop workshop) {
        this.workshop = workshop;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(51) + 10);
            workshop.postWish(Gift.getGift());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
