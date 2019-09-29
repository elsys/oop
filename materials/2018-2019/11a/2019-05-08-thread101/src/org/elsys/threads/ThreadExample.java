package org.elsys.threads;

import java.util.Random;

public class ThreadExample extends Thread {

    private static Random random = new Random();

    @Override
    public void run() {
        System.out.println("From thread, going to sleep...");
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Woke up!");
    }

    public static void main(String[] args) {
	    Thread[] threads = new Thread[10];
	    for (int i = 0; i < 10; i++) {
	        threads[i] = new ThreadExample();
	        threads[i].start();
	        // threads[i].start(); -> will throw Exception
        }

	    for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All threads finished!");
    }
}
