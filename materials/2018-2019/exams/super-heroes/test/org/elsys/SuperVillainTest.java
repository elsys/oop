package org.elsys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SuperVillainTest
{

	private Universe universe;

	private SuperVillain superVillain;
	private ByteArrayOutputStream outContent;

	@BeforeEach
	void setUp() {
		superVillain = Factory.createSuperVillain("Lex Luthor");
		universe = Factory.createUniverse("DC");
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void testGetName() {
		Assertions.assertEquals("Lex Luthor", superVillain.getName());
	}

	@Test
	void testIsGood() {
		Assertions.assertFalse(superVillain.isGood());
	}

	@Test
	void testGetUniverse() {
		superVillain.setUniverse(universe);
		Assertions.assertEquals(universe, superVillain.getUniverse());
	}

	@Test
	void testActWithOutUniverse() {
		Assertions.assertThrows(UniverseError.class, () -> superVillain.act());
	}

	@Test
	void testAct() {
		superVillain.setUniverse(new Universe("") {
			@Override
			public void actNasty(SuperVillain villain)
			{
				System.out.println(villain.getName() + " acted.");
			}
		});
		superVillain.act();
		Assertions.assertEquals("Lex Luthor will act.\n" +
								"Lex Luthor does nasty things! (evil laugh)\n" +
								"Lex Luthor acted.\n" +
								"Lex Luthor will now have some rest.\n", outContent.toString());
	}
}
