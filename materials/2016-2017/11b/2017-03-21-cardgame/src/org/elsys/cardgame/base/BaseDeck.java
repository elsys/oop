package org.elsys.cardgame.base;

import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Hand;

public abstract class BaseDeck implements Deck {

	protected abstract List<Card> getCards();

	@Override
	public int getRemainingCount() {
		return getCards().size();
	}

	@Override
	public Hand deal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub

	}

	@Override
	public Card drawTopCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card topCard() {
		// TODO Auto-generated method stub
		return null;
	}

}
