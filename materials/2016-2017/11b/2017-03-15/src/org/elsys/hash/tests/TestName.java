package org.elsys.hash.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.elsys.hash.Name;
import org.junit.Test;

public class TestName {

	@Test
	public void testNotEquals() {
		Name n1 = new Name("Pesho", "Peshev");
		Name n2 = new Name("Ivan", "Ivanov");
		
		assertFalse(n1.equals(n2));
	}

	
	@Test
	public void testEquals() {
		Name n1 = new Name("P","P"); 
		Name n2 = new Name("P", "P");
		
		assertTrue(n1.equals(n2));
	}
	
	@Test
	public void testHashSet() {
		Set<Name> s = new HashSet<Name>();
		
		Name n1 = new Name("P","P");
		s.add(n1);
		assertTrue(s.contains(n1));
		
		assertTrue(s.contains(new Name("P", "P")));
		
		
	}
}
