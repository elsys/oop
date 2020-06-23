package org.elsys.duzunov;

import java.time.LocalDateTime;
import java.util.HashMap;

public class CashDesk {
    private static final int MAX_CARDS = 1000;
    private static final int CARD_PRICE = 50;
    private static final int DEPOSIT = 1;

    private int amount = 0;
    private final HashMap<String, LocalDateTime> cards =
            new HashMap<>(MAX_CARDS);

    /**
     * Gives a card to a snowboarder. The snowboarder pays CARD_PRICE + DEPOSIT.
     */
    public synchronized void buyCard(Snowboarder snowboarder) {
        if (getActiveCardsCount() == MAX_CARDS) {
            throw new IllegalStateException();
        }

        amount += CARD_PRICE + DEPOSIT;
        cards.put(snowboarder.getName(), LocalDateTime.now());
    }

    /**
     * Returns the deposit to a snowboarder.
     */
    public synchronized void returnCard(Snowboarder snowboarder) {
        cards.remove(snowboarder.getName());
        amount -= DEPOSIT;
    }

    /**
     * Returns the cash amount currently contained in this cash desk.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Returns the maximum number of available cards in this cash desk.
     */
    public int getMaxAvailableCardsCount() {
        return MAX_CARDS;
    }

    /**
     * Returns the number of cards currently taken and not returned by the
     * snowboarders.
     */
    public int getActiveCardsCount() {
        return cards.size();
    }

    /**
     * Returns the number of available cards currently contained in this cash
     * desk.
     */
    public int getAvailableCardsCount() {
        return getMaxAvailableCardsCount() - getActiveCardsCount();
    }
}
