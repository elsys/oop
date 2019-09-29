package org.elsys.threads;

public class DeadlockExample {

    public static long counter1 = 0L;
    public static long counter2 = 0L;

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Starting...");
            for (int j = 0; j < 10000; j++) {
                System.out.println("Waiting for lock1");
                synchronized (lock1) {
                    counter1++;
                    System.out.println("Waiting for lock2");
                    synchronized (lock2) {
                        counter2++;
                    }
                    System.out.println("Released lock2");
                }
                System.out.println("Released lock1");
            }
            System.out.println("Finished");
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("Starting...");
            for (int j = 0; j < 10000; j++) {
                System.out.println("Waiting for lock2");
                synchronized (lock2) {
                    counter2++;
                    System.out.println("Waiting for lock1");
                    synchronized (lock1) {
                        counter1++;
                    }
                    System.out.println("Released lock1");
                }
                System.out.println("Released lock2");
            }
            System.out.println("Finished");
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Exit of main, counter1=" + counter1
                + ", counter2=" + counter2);
    }

}
