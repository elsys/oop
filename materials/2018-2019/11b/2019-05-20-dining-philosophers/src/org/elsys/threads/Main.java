package org.elsys.threads;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String[] names = { "Socrates", "Plato", "Aristotle", "Confucius", "Lao Tze" };

        List<Fork> forks = IntStream.range(0, names.length)
                .mapToObj(i -> new Fork())
                .collect(Collectors.toList());

        List<Thread> threads = IntStream.range(0, names.length - 1)
                .mapToObj(i -> new Philosopher(names[i], forks.get(i),
                        forks.get(i)))
                .map(Thread::new) // phil -> new Thread(phil)
                .peek(Thread::start) // th -> th.start()
                .collect(Collectors.toList());

        int last = names.length - 1;
        threads.add(new Thread(new Philosopher(names[last],
                forks.get((last+1) % forks.size()), forks.get(last))));

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
