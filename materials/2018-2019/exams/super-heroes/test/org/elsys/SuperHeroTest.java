package org.elsys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SuperHeroTest {

	private Universe universe;

	private SuperHero superHero;
	private ByteArrayOutputStream outContent;

	@BeforeEach
	void setUp() {
		superHero = Factory.createSuperHero("Superman", Factory.createSuperVillain("Lex Luthor"));
		universe = Factory.createUniverse("DC");
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void testGetName() {
		Assertions.assertEquals("Superman", superHero.getName());
	}

	@Test
	void testIsGood() {
		Assertions.assertTrue(superHero.isGood());
	}

	@Test
	void testGetUniverse() {
		superHero.setUniverse(universe);
		Assertions.assertEquals(universe, superHero.getUniverse());
	}

	@Test
	void testActWithOutUniverse() {
		Assertions.assertThrows(UniverseError.class, () -> superHero.act());
	}

	@Test
	void testAct() {
		superHero.setUniverse(new Universe("") {
			@Override
			public void beat(SuperHero hero, SuperVillain villain)
			{
				Assertions.assertEquals(superHero.getAntagonist(), villain);
				System.out.println(hero.getName() + " acted.");
			}
		});
		superHero.act();
		Assertions.assertEquals("Superman will act.\n" +
								"Superman acted.\n" +
								"Superman will now have some rest.\n", outContent.toString());
	}
}
