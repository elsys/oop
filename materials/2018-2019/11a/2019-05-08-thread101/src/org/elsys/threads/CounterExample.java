package org.elsys.threads;

public class CounterExample {

    public static long counter = 0L;

    public static Object lock = new Object();

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronized (lock) {
                        counter++;
                    }
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Counter: " + counter);
    }

    public static synchronized void increment() {
        //Class<CounterExample> aClass = CounterExample.class;
        counter++;
    }
}
