package org.elsys.duzunov;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final int KIDS_COUNT = 500;
        final int MILLISECONDS_TO_CHRISTMAS = 50;

        Workshop workshop = new Workshop();
        Kid[] kids = new Kid[KIDS_COUNT];
        for (int i = 0; i < KIDS_COUNT; ++i) {
            kids[i] = new Kid(workshop);
        }

        Arrays.stream(kids)
                .forEach(Thread::start);

        try {
            Thread.sleep(MILLISECONDS_TO_CHRISTMAS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        workshop.christmasTime();

        Arrays.stream(kids)
                .forEach(kid -> {
                    try {
                        kid.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        int wishCount = workshop.getWishCount();
        System.out.println(wishCount);

        Arrays.stream(workshop.getElves())
                .forEach(elf -> {
                    try {
                        elf.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        List<String> elfResults = Arrays.stream(workshop.getElves())
                .map(elf -> "Elf #" + elf.getId() + " created " +
                        elf.getTotalGiftsCrafted() + " gifts")
                .collect(Collectors.toList());
        elfResults.forEach(System.out::println);

        int totalGiftsCrafted = Arrays.stream(workshop.getElves())
                .mapToInt(Elf::getTotalGiftsCrafted)
                .sum();
        System.out.println(totalGiftsCrafted);

        try (var bufferedWriter =
                     new BufferedWriter(new FileWriter("results.txt"))
        ) {
            bufferedWriter.write(Integer.toString(wishCount));
            bufferedWriter.newLine();

            elfResults.forEach(elfResult -> {
                try {
                    bufferedWriter.write(elfResult);
                    bufferedWriter.newLine();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            });

            bufferedWriter.write(Integer.toString(totalGiftsCrafted));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
