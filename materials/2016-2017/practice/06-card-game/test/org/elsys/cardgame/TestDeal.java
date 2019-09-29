package org.elsys.cardgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.impl.WarGame;
import org.junit.Test;

public class TestDeal extends AbstractWarTest {

	@Test
	public void testDeal() {
		game.process("deal");
		assertNotNull(game.getDealtHand());
		List<Card> cards = game.getDealtHand().getCards();
		assertEquals(clearDeck.subList(0, 26), cards);
	}

	@Test
	public void testDealAndSize() {
		game.process("deal");
		assertEquals(26, game.getDeck().size());
	}

	@Test
	public void testTwiceDeal() {
		Game game = new WarGame();
		game.process("deal");
		game.process("deal");
		assertNotNull(game.getDealtHand());

		List<Card> handCards = game.getDealtHand().getCards();

		assertEquals(clearDeck.subList(26, 52), handCards);
	}

	@Test(expected = CardException.class)
	public void testTripleDeal() {
		Game game = new WarGame();
		game.process("deal");
		game.process("deal");
		game.process("deal");
	}
}
