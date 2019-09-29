package org.elsys.cardgame.impl;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Operation;

public class DrawTopCard implements Operation {

	@Override
	public String getName() {
		return "draw_top_card";
	}

	@Override
	public void execute(Game game, String... params) {
		Card topCard = game.getDeck().drawTopCard();
		System.out.println(topCard);
	}

}
