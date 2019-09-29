package org.elsys.hash;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestName {

	@Test
	public void testEquals() {
		Name n1 = new Name("A", "B");
		Name n2 = new Name("A", "B");

		assertEquals(n1, n2);
		assertTrue(n1.equals(n2));
	}

	@Test
	public void testNotEquals() {
		Name n1 = new Name("A", "B");
		Name n2 = new Name("C", "D");

		assertNotEquals(n1, n2);
	}

	@Test
	public void testHashSet() {
		Name n1 = new Name("A", "B");
		Set<Name> s = new HashSet<Name>();
		s.add(n1);

		assertTrue(s.contains(n1));

		Name n2 = new Name("A", "B");
		assertEquals(n1, n2);

		assertTrue(s.contains(n2));

		assertFalse(s.contains(new Name("C", "D")));
	}

}
