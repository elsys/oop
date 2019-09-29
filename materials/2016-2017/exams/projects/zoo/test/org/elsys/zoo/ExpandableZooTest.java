package org.elsys.zoo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

public class ExpandableZooTest {

	@Test
	public void testMaxCapacity() {
		ExpandableZoo zoo = new ExpandableZoo(10, 10);
		assertTrue(zoo.add(new TestAnimal()));
		assertTrue(zoo.add(new TestAnimal()));
	}
	
	@Test
	public void testMaxFoodCapacityWhenOver() {
		ExpandableZoo zoo = new ExpandableZoo(10, 9);
		assertTrue(zoo.add(new TestAnimal()));
		assertTrue(zoo.add(new TestAnimal()));
	}

	@Test(expected = NotEnoughCapacityException.class)
	public void testMaxCountCapacityWithAddAll() {
		ExpandableZoo zoo = new ExpandableZoo(1, 10);
		zoo.addAll(Arrays.asList(new TestAnimal(), new TestAnimal()));
	}

}
