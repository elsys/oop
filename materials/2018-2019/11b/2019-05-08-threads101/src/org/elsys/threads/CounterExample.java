package org.elsys.threads;

import org.w3c.dom.css.Counter;

public class CounterExample {
    public static long counter = 0L;

    public static Object lock = new Object();

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                System.out.println("Starting...");
                for (int j = 0; j < 10000; j++) {
                    synchronized (lock) {
//                    synchronized (CounterExample.class) {
                        counter++;
                    }
                }
                decrement(10);
                System.out.println("Finished");
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exit of main, counter=" + counter);
    }

    private static synchronized void decrement(int i) {
        counter -= i;
    }
}
