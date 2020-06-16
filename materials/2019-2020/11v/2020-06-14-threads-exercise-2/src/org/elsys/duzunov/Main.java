package org.elsys.duzunov;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int KIDS_COUNT = 500;
        final int MILLISECONDS_TO_CHRISTMAS = 5_0;

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

        System.out.println(workshop.getWishCount());

        Arrays.stream(workshop.getElves())
                .forEach(elf -> {
                    try {
                        elf.join();
                        System.out.println(
                                "Elf #" + elf.getId() + " created " +
                                        elf.getTotalGiftsCrafted() + " gifts"
                        );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println(
                Arrays.stream(workshop.getElves())
                        .mapToInt(Elf::getTotalGiftsCrafted)
                        .sum()
        );
    }
}
