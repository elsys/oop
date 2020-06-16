package org.elsys.duzunov;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Workshop {
    private static final int ELVES_COUNT = 20;

    private final LinkedBlockingQueue<Gift> gifts = new LinkedBlockingQueue<>();
    private final Elf[] elves = new Elf[ELVES_COUNT];
    private final AtomicInteger wishCount = new AtomicInteger();
    private boolean isChristmasTime = false;

    public Workshop() {
        for (int i = 0; i < ELVES_COUNT; ++i) {
            elves[i] = new Elf(i, this);
        }

        Arrays.stream(elves)
                .forEach(Thread::start);
    }

    /**
     * Adds a gift to the elves' backlog.
     **/
    public void postWish(Gift gift) {
        try {
            gifts.put(gift);
            wishCount.incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns an array of the elves working in Santa's workshop.
     **/
    public Elf[] getElves() {
        return elves;
    }

    /**
     * Returns the next gift from the elves' backlog that has to be
     * manufactured.
     **/
    public Gift nextGift() {
        try {
            return gifts.poll(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the total number of wishes sent to Santa's workshop by the kids.
     **/
    public int getWishCount() {
        return wishCount.intValue();
    }

    public boolean hasRemainingWishes() {
        return !gifts.isEmpty();
    }

    public boolean getIsChristmasTime() {
        return isChristmasTime;
    }

    public void christmasTime() {
        isChristmasTime = true;
    }
}
