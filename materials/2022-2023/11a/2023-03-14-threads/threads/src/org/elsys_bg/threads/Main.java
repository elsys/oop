package org.elsys_bg.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello world!");
//        Thread t = new Thread(new ThreadOne());
//        t.start();
//        Thread t2 = new ThreadTwo();
//        t2.setName("Thread two");
//        t2.start();

        List<Thread> threadList = new ArrayList<>();


        Counter c = new Counter();
        for (int i = 0; i < 10_000; i++) {
            Thread t = new Thread(new Incrementer(c));
            threadList.add(t);
            t.start();
        }

        for(Thread t : threadList) {
            t.join();
        }

//        threadList.forEach(thread -> thread.join());

        System.out.println(c.getCount());

    }

    public static class ThreadOne implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello World Thread");
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from: " + Thread.currentThread().getName());
        }
    }
}