package org.elsys.cardgame;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.junit.Test;

public class TestHighest extends AbstractWarTest {

	@Test(expected = CardException.class)
	public void testHighestBeforeDeal() {
		game.process("highest");
	}

	@Test
	public void testHighest() {
		game.process("deal");
		game.process("highest");

		List<Card> expectedHand = clearDeck.subList(0, 26);
		Card highest = expectedHand.stream().sorted().collect(Collectors.toList()).remove(expectedHand.size() - 1);
		assertFalse(game.getDealtHand().getCards().contains(highest));
		expectedHand.remove(highest);
		assertEquals(expectedHand, game.getDealtHand().getCards());
	}

}
