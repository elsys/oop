package org.elsys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniverseTest {

	private Universe universe;
	private SuperVillain villain;
	private SuperHero hero;
	private ByteArrayOutputStream outContent;

	@BeforeEach
	void setUp() {
		villain = Factory.createSuperVillain("Lex Luthor");
		hero = Factory.createSuperHero("Superman", villain);
		universe = Factory.createUniverse("DC");
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void testGetName() {
		assertEquals("DC", universe.getName());
	}

	@Test
	void testAddCharacter() {
		universe.addCharacter(hero);
		assertEquals(0, universe.getScore(hero));
	}

	@Test
	void testBeat() {
		universe.addCharacter(hero);
		universe.addCharacter(villain);
		universe.beat(hero, villain);
		assertEquals(1, universe.getScore(hero));
		assertEquals("Lex Luthor was killed.\n", outContent.toString());
		assertTrue(universe.getDeadVillains().contains(villain));
	}

	@Test
	void testGetBeatFail() {
		assertThrows(UniverseError.class, () -> universe.beat(hero, villain));
		universe.addCharacter(hero);
		assertThrows(UniverseError.class, () -> universe.beat(hero, villain));
		universe.addCharacter(villain);
		universe.beat(hero, villain);
	}

	@Test
	void testActNasty() {
		assertThrows(UniverseError.class, () -> universe.actNasty(villain));
		universe.addCharacter(villain);
		universe.actNasty(villain);
		universe.actNasty(villain);
		assertEquals(2, universe.getScore(villain));
	}

	@Test
	void testGetScoreFail()	{
		assertThrows(UniverseError.class, () -> universe.getScore(hero));
	}

	@Test
	void testTopCharacter() {
		universe.addCharacter(hero);
		universe.addCharacter(villain);
		universe.actNasty(villain);
		universe.actNasty(villain);
		universe.actNasty(villain);
		universe.beat(hero, villain);
		Assertions.assertEquals(villain, universe.getTopCharacter());
	}

	@Test
	void resurrectVillain() {
		universe.addCharacter(hero);
		universe.addCharacter(villain);
		universe.beat(hero, villain);
		universe.resurrectVillain(villain);
		assertEquals(0, universe.getScore(villain));
		assertThrows(UniverseError.class, () -> universe.resurrectVillain(villain));
	}

	@Test
	void testGetHeroesByScore() {
		assertEquals(0, universe.getHeroesByScore().size());
		universe.addCharacter(hero);
		universe.addCharacter(villain);
		assertEquals(Arrays.asList(hero), universe.getHeroesByScore().get(0));
		universe.beat(hero, villain);
		assertEquals(Arrays.asList(hero), universe.getHeroesByScore().get(1));
		SuperHero otherHero = Factory.createSuperHero("Batman",
													  Factory.createSuperVillain("Jocker"));
		universe.addCharacter(otherHero);
		Map<Integer, List<SuperHero>> heroesByScore = universe.getHeroesByScore();
		assertEquals(Arrays.asList(hero), heroesByScore.get(1));
		assertEquals(Arrays.asList(otherHero), heroesByScore.get(0));
	}
}
