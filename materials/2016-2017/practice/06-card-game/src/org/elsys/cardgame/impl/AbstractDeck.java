package org.elsys.cardgame.impl;

import java.util.ArrayList;
import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Hand;

public abstract class AbstractDeck implements Deck {

	@Override
	public Card drawTopCard() {
		return getCards().remove(0);
	}

	@Override
	public Card topCard() {
		return getCards().get(0);
	}

	@Override
	public Card bottomCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card drawBottomCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hand deal() {
		List<Card> handCards = new ArrayList<>();
		for (int i = 0; i < handSize(); i++) {
			handCards.add(getCards().remove(0));
		}
		return new HandImpl(handCards);
	}

	@Override
	public void sort() {
		 // TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return 0;
	}

}
