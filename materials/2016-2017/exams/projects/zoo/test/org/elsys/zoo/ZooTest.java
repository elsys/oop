package org.elsys.zoo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ZooTest {

	@Test
	public void testAdd() {
		Zoo zoo = new Zoo(10, 100);
		TestAnimal shape1 = new TestAnimal();
		TestAnimal shape2 = new TestAnimal();

		assertTrue(zoo.add(shape1));
		assertTrue(zoo.add(shape2));
	}

	@Test
	public void testRemove() {
		Zoo zoo = new Zoo(10, 100);
		TestAnimal shape1 = new TestAnimal();

		zoo.add(shape1);
		assertTrue(zoo.remove(shape1));
		assertFalse(zoo.contains(shape1));
	}

	@Test
	public void testTotalArea() {
		Zoo zoo = new Zoo(10, 100);

		zoo.add(new TestAnimal());
		zoo.add(new TestAnimal());
		assertEquals(10, zoo.getCurrentFoodPerDayAmount(), 0.01);
	}

	@Test
	public void testNull() {
		Zoo zoo = new Zoo(10, 10);
		assertFalse(zoo.add(null));
	}
	
	@Test
	public void testMaxCapacity() {
		Zoo zoo = new Zoo(10, 10);
		assertTrue(zoo.add(new TestAnimal()));
		assertTrue(zoo.add(new TestAnimal()));
	}
	
	@Test(expected = NotEnoughCapacityException.class)
	public void testMaxFoodCapacityWhenOver() {
		Zoo zoo = new Zoo(10, 9);
		assertTrue(zoo.add(new TestAnimal()));
		zoo.add(new TestAnimal());
	}

	@Test(expected = NotEnoughCapacityException.class)
	public void testMaxCountCapacityWithAddAll() {
		Zoo zoo = new Zoo(1, 10);
		zoo.addAll(Arrays.asList(new TestAnimal(), new TestAnimal()));
	}
}
