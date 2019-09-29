package org.elsys.cardgame.impl;

import java.util.Comparator;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;

public class CardImpl implements Card {

	private Suit suit;
	private Rank rank;
	private Comparator<Card> comparator;

	public CardImpl(Suit suit, Rank rank, Comparator<Card> comparator) {
		this.suit = suit;
		this.rank = rank;
		this.comparator = comparator;
	}

	@Override
	public Suit getSuit() {
		return suit;
	}

	@Override
	public Rank getRank() {
		return rank;
	}

	@Override
	public int compareTo(Card other) {
		return comparator.compare(this, other);
	}

	@Override
	public String toString() {
		return suit.getSymbol() + rank.getSymbol();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardImpl other = (CardImpl) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}
