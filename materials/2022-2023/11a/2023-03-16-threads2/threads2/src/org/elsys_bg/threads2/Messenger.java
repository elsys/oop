package org.elsys_bg.threads2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Messenger implements IMessenger {
    private String message;
    private boolean available;

    public synchronized String getMessage() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        notifyAll();
        available = false;
        return message;
    }

    public void sendMessage(String message) {
        synchronized (this) {
            while (available) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        available = true;
        this.message = message;
        synchronized (this) {
            notifyAll();
        }
    }
}
