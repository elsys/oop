package org.elsys.cardgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestSortAndShuffle extends AbstractWarTest {

	@Test
	public void testShuffle() {
		game.process("shuffle");
		assertNotEquals(game.getDeck().getCards(), clearDeck);
	}
	
	@Test
	public void testSort() {
		game.process("shuffle");
		game.process("sort");
		assertEquals(game.getDeck().getCards(), clearDeck);
	}

}
