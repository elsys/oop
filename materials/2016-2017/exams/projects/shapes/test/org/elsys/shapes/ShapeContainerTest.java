package org.elsys.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShapeContainerTest {

	@Test
	public void testAdd() {
		ShapeContainer container = new ShapeContainer();
		TestShape shape1 = new TestShape(10.1);
		TestShape shape2 = new TestShape(10.2);

		assertTrue(container.add(shape1));
		assertTrue(container.add(shape2));
	}

	@Test
	public void testRemove() {
		ShapeContainer container = new ShapeContainer();
		TestShape shape1 = new TestShape(10.1);

		container.add(shape1);
		assertTrue(container.remove(shape1));
		assertFalse(container.contains(shape1));
	}

	@Test
	public void testTotalArea() {
		ShapeContainer container = new ShapeContainer();

		container.add(new TestShape(2.01));
		container.add(new TestShape(2.0));
		assertEquals(4.01,
				container.getTotalArea(), 0.01);
	}

}
