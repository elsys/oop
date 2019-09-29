package org.elsys.cardgame.impl;

import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Operation;

public class Deal implements Operation {

	@Override
	public String getName() {
		return "deal";
	}

	@Override
	public void execute(Game game, String... params) {
		Hand hand = game.getDeck().deal();
		game.setDealtHand(hand);
	}

}
