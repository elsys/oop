package org.elsys.threads;

public class ThreadExample extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from thread, going to sleep!");
        try {
            Thread.sleep(2000);
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
	        // threads[i].start(); -> will throw exception
        }

	    for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("End of main");
    }
}
