package org.elsys_bg.threads2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class MessengerV2 implements IMessenger{
    private String message;
    private boolean available;

    private Lock lock = new ReentrantLock();
    private Condition messageAvailable = lock.newCondition();
    private Condition messageNotAvailable = lock.newCondition();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public String getMessage() {


//        readWriteLock.readLock().lock();
//        readWriteLock.readLock().lock();
//        readWriteLock.writeLock().lock();

        lock.lock();

        try {
            while (!available) {
                try {
                    messageNotAvailable.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            messageAvailable.signalAll();
            available = false;
            return message;
        } finally {
            lock.unlock();
        }
    }

    public void sendMessage(String message) {
        lock.lock();
        try {
            while (available) {
                try {
                    messageAvailable.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            available = true;
            this.message = message;
            messageNotAvailable.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
