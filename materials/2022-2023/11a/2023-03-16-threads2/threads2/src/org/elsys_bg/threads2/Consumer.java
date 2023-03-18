package org.elsys_bg.threads2;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {

    private IMessenger messenger;

    public Consumer(IMessenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void run() {
        String message = "";
        while (!"END".equalsIgnoreCase(message)) {
            message = messenger.getMessage();
            System.out.println("Message: " + message);
            try {
                sleep(ThreadLocalRandom.current().nextInt(5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
