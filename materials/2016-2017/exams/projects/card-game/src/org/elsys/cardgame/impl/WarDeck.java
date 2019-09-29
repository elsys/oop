package org.elsys.cardgame.impl;

import static org.elsys.cardgame.api.Suit.*;
import static org.elsys.cardgame.api.Rank.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;

public class WarDeck extends AbstractDeck implements Deck {

	public static final List<Suit> WAR_SUITS_ASC = Arrays.asList(CLUBS, DIAMONDS, HEARTS, SPADES);
	public static final List<Rank> WAR_RANKS_ASC = Arrays.asList(TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
			JACK, QUEEN, KING, ACE);
	
	private List<Card> cards;

	public WarDeck() {
		cards = generateDeck();
	}

	public static List<Card> generateDeck() {
		List<Card> cards = new ArrayList<>();
		for (Suit suit : WAR_SUITS_ASC) {
			for (Rank rank : WAR_RANKS_ASC) {
				cards.add(new CardImpl(suit, rank, getCardComparator()));
			}
		}
		return cards;
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public int handSize() {
		return 26;
	}

	public static Comparator<Card> getCardComparator() {
		// TODO implement me!
		return null;
	}

}
