package org.elsys.duzunov;

public class Elf extends Thread {
    private final int id;
    private final Workshop workshop;
    private int totalGiftsCrafted = 0;

    public Elf(int id, Workshop workshop) {
        this.id = id;
        this.workshop = workshop;
    }

    /**
     * Gets a wish from the backlog and creates the wanted gift.
     **/
    public void craftGift() {
        Gift gift = workshop.nextGift();
        if (gift == null) {
            return;
        }

        try {
            Thread.sleep(gift.getCraftTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ++totalGiftsCrafted;
    }

    /**
     * Returns the total number of gifts that the given elf has crafted.
     **/
    public int getTotalGiftsCrafted() {
        return totalGiftsCrafted;
    }

    @Override
    public void run() {
        while (!workshop.getIsChristmasTime() ||
                workshop.hasRemainingWishes()) {
            craftGift();
        }
    }
}
