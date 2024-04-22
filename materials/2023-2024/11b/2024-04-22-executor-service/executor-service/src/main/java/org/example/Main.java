package org.example;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(5); // === .newSingleThreadExecutor();
        ((Executor)ex).execute(() -> System.out.println(Thread.currentThread().getName() + ": Inside thread"));
        ((Executor)ex).execute(() -> System.out.println(Thread.currentThread().getName() + ": Inside thread"));
        ((Executor)ex).execute(() -> System.out.println(Thread.currentThread().getName() + ": Inside thread"));
        /*((Executor)ex).execute(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted()) return;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });*/

        Future res = ex.submit(() -> 1234);
        try {
            System.out.println(res.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ex.shutdown();
        //if(!ex.isShutdown()) {
        //    List<Runnable> tasks = ex.shutdownNow();
            //tasks.get(0).
       // }


    }
}