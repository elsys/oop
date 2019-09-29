package org.elsys.cardgame.impl;

import java.util.ArrayList;

import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.base.BaseGame;

public class WarGame extends BaseGame implements Game {

	public WarGame() {
		super(new WarDeck(), new ArrayList<>());
	}

	@Override
	public String getName() {
		return "War";
	}

	@Override
	public int getHandSize() {
		return 26;
	}

}
