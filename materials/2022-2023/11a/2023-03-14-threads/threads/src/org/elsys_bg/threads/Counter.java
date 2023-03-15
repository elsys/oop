package org.elsys_bg.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int count = 0;
    private int count2 = 0;

    private Object lock1;
    private Object lock2;

    private AtomicInteger counter3 = new AtomicInteger(0);


    public void increment() {
        synchronized (lock1) {
            count++;
        }

        //db call
        //service call

        synchronized (lock1) {

        }

    }

    public void increment3() {
        counter3.incrementAndGet();
    }

    public void increment2() {
        synchronized (lock2) {
            count2++;
        }
    }

    public int getCount() {
//        return count;
        return counter3.get();
    }
}
