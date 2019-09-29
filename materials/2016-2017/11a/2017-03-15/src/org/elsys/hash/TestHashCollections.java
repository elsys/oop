package org.elsys.hash;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestHashCollections {

	@Test
	public void testHashMap() {
		Map<String, Integer> m = new HashMap<String, Integer>();

		m.put("a", 10);
		m.put("b", 11);

		assertTrue(m.containsKey("a"));
		assertFalse(m.containsKey("c"));

		int val = m.get("a");
		assertEquals(10, val);
		assertEquals(11, (int) m.get("b"));
	}
	
	@Test
	public void testHashSet() {
		Set<String> s = new HashSet<String>();
		s.add("a");
		s.add("b");
		
		
		assertTrue(s.contains("a"));
		assertFalse(s.contains("c"));
	}

}
