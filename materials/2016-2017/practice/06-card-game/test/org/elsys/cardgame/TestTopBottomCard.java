package org.elsys.cardgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.junit.Test;

public class TestTopBottomCard extends AbstractWarTest {

	@Test
	public void testTopCard() {
		Card topCard = game.getDeck().topCard();
		Card expectedTopCard = clearDeck.get(0);
		assertEquals(topCard, expectedTopCard);
		game.process("top_card");
	}

	@Test
	public void testDrawTopCard() {
		Card topCard = game.getDeck().topCard();
		game.process("draw_top_card");
		Card newTopCard = game.getDeck().topCard();
		assertNotEquals(newTopCard, topCard);
		game.process("draw_top_card");
		assertNotEquals(newTopCard, game.getDeck().topCard());
	}

	@Test
	public void testBottomCard() {
		Card bottomCard = game.getDeck().bottomCard();
		Card expectedBottomCard = clearDeck.get(clearDeck.size() - 1);
		assertEquals(bottomCard, expectedBottomCard);
		game.process("bottom_card");
	}

	@Test
	public void testDrawBottomCard() {
		Card bottomCard = game.getDeck().bottomCard();
		game.process("draw_bottom_card");
		Card newBottomCard = game.getDeck().bottomCard();
		assertNotEquals(newBottomCard, bottomCard);
		game.process("draw_bottom_card");
		assertNotEquals(newBottomCard, game.getDeck().bottomCard());
	}

	@Test(expected = CardException.class)
	public void test53TimeDrawTopCard() {
		for (int i = 0; i < 53; i++) {
			game.process("draw_top_card");
		}
	}

	@Test
	public void topCardNullsDealtHand() {
		game.process("deal");
		assertNotNull(game.getDealtHand());
		game.process("top_card");
		assertNull(game.getDealtHand());
	}

	@Test
	public void drawBottomCardNullsDealtHand() {
		game.process("deal");
		assertNotNull(game.getDealtHand());
		game.process("draw_bottom_card");
		assertNull(game.getDealtHand());
	}

	@Test(expected = CardException.class)
	public void testDealAndDrawTopCard() {
		game.process("deal");

		Card topCardAfterDeal = game.getDeck().topCard();
		Card expectedTopCardAfterDeal = clearDeck.get(26);
		assertEquals(expectedTopCardAfterDeal, topCardAfterDeal);

		game.process("deal");
		game.process("top_card");
	}
}
