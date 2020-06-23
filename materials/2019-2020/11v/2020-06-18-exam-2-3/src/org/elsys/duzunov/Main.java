package org.elsys.duzunov;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int SNOWBOARDERS_COUNT = 5000;

        CashDesk cashDesk = new CashDesk();

        Snowboarder[] snowboarders = new Snowboarder[SNOWBOARDERS_COUNT];
        for (int i = 0; i < snowboarders.length; ++i) {
            snowboarders[i] = new Snowboarder(Integer.toString(i), cashDesk);
        }

        Thread reporter = new Thread(() -> {
            while (true) {
                System.out.println(
                        "Cash desk balance: " + cashDesk.getAmount()
                );
                System.out.println(
                        "Cash desk active cards count: " +
                                cashDesk.getActiveCardsCount()
                );
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        reporter.setDaemon(true);
        reporter.start();

        ExecutorService threadPool =
                Executors.newFixedThreadPool(
                        cashDesk.getMaxAvailableCardsCount()
                );

        Arrays.stream(snowboarders)
                .forEach(threadPool::submit);

        threadPool.shutdown();

        while (!threadPool.isTerminated()) {
            try {
                threadPool.awaitTermination(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cashDesk.getAvailableCardsCount());
        System.out.println(cashDesk.getMaxAvailableCardsCount());
        System.out.println(cashDesk.getAmount());
        System.out.println(snowboarders.length * 50);
    }
}
