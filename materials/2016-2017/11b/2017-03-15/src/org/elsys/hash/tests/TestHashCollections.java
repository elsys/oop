package org.elsys.hash.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestHashCollections {

	@Test
	public void testHashMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("a", 10);
		map.put("b", 11);

		assertTrue(map.containsKey("a"));
		assertTrue(map.containsKey("b"));

		assertFalse(map.containsKey("ъ"));

		int val = map.get("a");

		assertEquals(10, val);

	}

	@Test
	public void testHashSet() {
		Set<String> s = new HashSet<String>();

		s.add("a");
		s.add("b");

		assertTrue(s.contains("a"));
		assertTrue(s.contains("b"));
		
		assertFalse(s.contains("c"));
	}

}
