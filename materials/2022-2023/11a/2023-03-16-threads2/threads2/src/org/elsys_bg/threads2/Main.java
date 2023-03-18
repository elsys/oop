package org.elsys_bg.threads2;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Messenger messenger = new Messenger();
        IMessenger messenger1 = new MessengerV2();
        Thread producer = new Thread(new Producer(messenger1));
        Thread consumer = new Thread(new Consumer(messenger1));

//        producer.start();
//        consumer.start();

        Executor executor = Executors.newFixedThreadPool(10);
        executor.execute(producer);
        executor.execute(consumer);
    }
}