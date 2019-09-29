package org.elsys.threads;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Socrates", "Platon", "Aristotle", "Thales", "Solomon"};
        Table table = new Table(names.length);

        List<Philosopher> philosophers = Arrays.stream(names)
                .map(name -> new Philosopher(name))
                .collect(Collectors.toList());

        for (int i = 0; i < names.length; i++) {
            table.seat(i, philosophers.get(i));
        }

        List<Thread> threads = philosophers.stream()
                .map(Thread::new) // philosopher -> new Thread(philosopher)
                .peek(Thread::start) // th -> th.start()
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
