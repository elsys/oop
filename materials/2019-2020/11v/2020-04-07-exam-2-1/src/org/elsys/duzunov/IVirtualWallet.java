package org.elsys.duzunov;

import java.util.Collection;

public interface IVirtualWallet {
    /**
     * Registers a new card in the wallet.
     * Returns true if the operation is successful and false
     * if there is already a card with the same name.
     **/
    boolean registerCard(Card card);

    /**
     * Unregisters a card from the wallet.
     * Returns true if the operation is successful and false
     * if there is no such card.
     **/
    boolean unregisterCard(Card card);

    /**
     * Executes a payment from the given card. Returns true
     * if the operation is successful and false otherwise.
     **/
    boolean executePayment(Card card, PaymentInfo paymentInfo);

    /**
     * Feeds the given card with @amount money. Returns true
     * if the operation is successful and false otherwise.
     **/
    boolean feed(Card card, double amount);

    /**
     * Returns a card from the wallet with the given name.
     * If there is no such card, returns null.
     **/
    Card getCardByName(String name);

    /**
     * Returns the current number of registered cards in the wallet.
     **/
    int getTotalNumberOfCards();

    /**
     * Returns a new collection of all registered cards sorted by name.
     * This method does not modify the order of registered cards
     * stored in the wallet.
     **/
    Collection<Card> sortCardsByName();

    /**
     * Returns a new collection of all registered cards sorted by amount.
     * This method does not modify the order of registered cards
     * stored in the wallet.
     **/
    Collection<Card> sortCardsByAmount();
}
