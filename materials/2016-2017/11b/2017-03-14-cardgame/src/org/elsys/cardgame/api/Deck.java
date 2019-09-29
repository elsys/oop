package org.elsys.cardgame.api;

public interface Deck {

	int getRemainingCount();

	Hand deal();

	void shuffle();

	void sort();

	Card drawTopCard();

	Card topCard();
}
