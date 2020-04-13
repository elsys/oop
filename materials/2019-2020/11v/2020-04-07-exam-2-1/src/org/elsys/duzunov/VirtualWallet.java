package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;

public class VirtualWallet implements IVirtualWallet {
    private static class AmountComparator implements Comparator<Card> {
        @Override
        public int compare(Card o1, Card o2) {
            return Double.compare(o1.getAmount(), o2.getAmount());
        }
    }

    private HashMap<String, Card> cards = new HashMap<>();

    @Override
    public boolean registerCard(Card card) {
        if (card == null || cards.containsKey(card.getName())) {
            return false;
        }

        cards.put(card.getName(), card);
        return true;
    }

    @Override
    public boolean unregisterCard(Card card) {
        return card != null && cards.remove(card.getName()) != null;
    }

    @Override
    public boolean executePayment(Card card, PaymentInfo paymentInfo) {
        if (card == null || paymentInfo == null) {
            return false;
        }

        var foundCard = getCardByName(card.getName());
        return foundCard != null &&
                foundCard.executePayment(paymentInfo.getCost());
    }

    @Override
    public boolean feed(Card card, double amount) {
        if (card == null) {
            return false;
        }

        var foundCard = getCardByName(card.getName());
        return foundCard != null && foundCard.feed(amount);
    }

    @Override
    public Card getCardByName(String name) {
        return cards.get(name);
    }

    @Override
    public int getTotalNumberOfCards() {
        return cards.size();
    }

    @Override
    public Collection<Card> sortCardsByName() {
        return sortCards(null);
    }

    @Override
    public Collection<Card> sortCardsByAmount() {
        return sortCards(new AmountComparator());
    }

    private Collection<Card> sortCards(Comparator<Card> cardComparator) {
        var cardsList = new ArrayList<>(cards.values());
        cardsList.sort(cardComparator);
        return cardsList;
    }
}
