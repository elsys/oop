package org.elsys.cardgame.game;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.factory.DeckFactory;
import org.elsys.cardgame.factory.GameFactory;

import java.util.List;

public class WarGameTest extends AbstractGameTest {
    @Override
    protected Game createGame(List<Card> cards) {
        return GameFactory.createWarGame(cards);
    }

    @Override
    public Deck defaultDeck() {
        return DeckFactory.defaultWarDeck();
    }

    @Override
    public int deckSize() {
        return 52;
    }

    @Override
    public int handSize() {
        return 26;
    }
}
