package org.elsys.cardgame.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;

public class WarDeck extends AbstractDeck implements Deck {

	private List<Card> cards;
	
	public WarDeck() {
		cards = new ArrayList<>();
		
	}

	@Override
	protected List<Card> getCards() {
		return cards;
	}

	@Override
	public int size() {
		return 52;
	}

	@Override
	public int handSize() {
		return 26;
	}

}
