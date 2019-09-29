package org.elsys.threads;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {

    private ReentrantLock lock = new ReentrantLock();

    public void get() {
        lock.lock();
    }

    public void put() {
        lock.unlock();
    }
}
