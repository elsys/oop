package org.elsys.cardgame;

import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.impl.WarDeck;
import org.elsys.cardgame.impl.WarGame;
import org.junit.Before;

public abstract class AbstractWarTest {

	protected Game game;

	protected List<Card> clearDeck;

	@Before
	public void beforeTest() {
		game = new WarGame();
		clearDeck = WarDeck.generateDeck();
	}
}
