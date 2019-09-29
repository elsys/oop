package org.elsys.threads;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Table {

    private List<Fork> forks;

    public Table(int seats) {
        forks = IntStream.range(0, seats)
                         .mapToObj(i -> new Fork())
                         .collect(Collectors.toList());
    }

    public void seat(int seat, Philosopher philosopher) {
        System.out.printf("%s seated at seat %d\n", philosopher.getName(), seat);
        if (seat == 0) {
            philosopher.setLeft(forks.get((seat + 1) % forks.size()));
            philosopher.setRight(forks.get(seat));
        } else {
            philosopher.setLeft(forks.get(seat));
            philosopher.setRight(forks.get((seat + 1) % forks.size()));
        }
    }
}