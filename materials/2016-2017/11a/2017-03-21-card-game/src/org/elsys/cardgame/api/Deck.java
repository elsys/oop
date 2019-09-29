package org.elsys.cardgame.api;

public interface Deck {

	int size();

	int handSize();

	Card drawTopCard();

	Card topCard();

	Hand deal();

	void sort();
}
