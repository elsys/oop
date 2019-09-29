package org.elsys.shapes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

public class ShapeBoxTest {

	@Test
	public void testMaxCapacity() {
		ShapeBox box = new ShapeBox(10);
		assertTrue(box.add(new TestShape(5)));
		assertTrue(box.add(new TestShape(5)));
	}
	
	@Test(expected = NotEnoughAreaException.class)
	public void testMaxCapacityWhenOver() {
		ShapeBox box = new ShapeBox(10);
		assertTrue(box.add(new TestShape(5)));
		box.add(new TestShape(6));
	}

	@Test(expected = NotEnoughAreaException.class)
	public void testMaxCapacityWithAddAll() {
		ShapeBox box = new ShapeBox(10);
		box.addAll(Arrays.asList(new TestShape(1), new TestShape(10)));
	}

	@Test
	public void testNull() {
		ShapeBox box = new ShapeBox(10);
		assertFalse(box.add(null));
	}

	@Test
	public void testIterator() {
		ShapeBox box = new ShapeBox(10);
		box.add(new TestShape(3));
		box.add(new TestShape(2));
		box.add(new TestShape(1));

		Iterator<Shape> iter = box.getShapesFromSmallest();
		assertEquals(1, iter.next().calculateArea(), 0.01);
		assertEquals(2, iter.next().calculateArea(), 0.01);
		assertEquals(3, iter.next().calculateArea(), 0.01);
		assertFalse(iter.hasNext());
	}
}
