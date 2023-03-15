package org.elsys_bg.threads;

public class Incrementer implements Runnable {
    private final Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
//            synchronized (counter) {
            counter.increment3();
//                counter.getCount();
//            }
        }
    }
}
