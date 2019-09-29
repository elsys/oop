package org.elsys.cardgame.impl;

import java.util.ArrayList;

import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.base.AbstractGame;

public class WarGame extends AbstractGame implements Game {

	public WarGame() {
		super(new WarDeck(), new ArrayList<>());
	}

}
