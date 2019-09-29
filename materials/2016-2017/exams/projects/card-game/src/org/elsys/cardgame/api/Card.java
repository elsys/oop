package org.elsys.cardgame.api;

public interface Card extends Comparable<Card> {

	Suit getSuit();

	Rank getRank();
}
