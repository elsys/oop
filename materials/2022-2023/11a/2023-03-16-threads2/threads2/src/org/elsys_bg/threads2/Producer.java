package org.elsys_bg.threads2;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class Producer implements Runnable {
    private IMessenger messenger;

    public Producer(IMessenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void run() {
        List<String> messages = List.of(
                "Hello",
                "My name is",
                "What",
                "END"
        );

        for (String message: messages) {
            messenger.sendMessage(message);
            try {
                sleep(ThreadLocalRandom.current().nextInt(5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
