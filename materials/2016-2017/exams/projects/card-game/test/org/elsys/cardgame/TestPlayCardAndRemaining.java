package org.elsys.cardgame;

import static org.junit.Assert.*;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.junit.Test;

public class TestPlayCardAndRemaining extends AbstractWarTest {

	@Test(expected = CardException.class)
	public void testPlayCardWithoutDealtHand() {
		game.process("play_card");
	}

	@Test
	public void testPlayCard() {
		game.process("deal");
		Card cardToPlay = game.getDealtHand().getCards().get(0);
		game.process("play_card");
		assertFalse(game.getDealtHand().getCards().contains(cardToPlay));
		assertEquals(25, game.getDealtHand().getCards().size());
	}

	@Test(expected = CardException.class)
	public void testRemainingWithOutDealtHand() {
		game.process("remaining");
	}

	@Test
	public void testRemaining() {
		game.process("deal");
		game.process("remaining");
	}
}
