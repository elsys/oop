package org.elsys.threads;

import java.util.ArrayList;
import java.util.List;

public class DeadlockExample {

    public static long counter1 = 0L;

    public static long counter2 = 0L;

    public static Object lock1 = new Object();

    public static Object lock2 = new Object();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(100);
        threads.add(new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                System.out.println("Waiting for lock1");
                synchronized (lock1) {
                    counter1++;
                    System.out.println("Waiting for lock2");
                    synchronized (lock2) {
                        counter2++;
                        System.out.println("Releasing lock2");
                    }
                    System.out.println("Releasing lock 1");
                }
            }
        }));
        threads.get(threads.size() - 1).start();
        threads.add(new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                System.out.println("Waiting for lock2");
                synchronized (lock2) {
                    counter2++;
                    System.out.println("Waiting for lock1");
                    synchronized (lock1) {
                        counter1++;
                        System.out.println("Releasing lock1");
                    }
                    System.out.println("Releasing lock2");
                }
            }
        }));
        threads.get(threads.size() - 1).start();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Counter1: " + counter1 + ", Counter2: " + counter2);
    }
}
