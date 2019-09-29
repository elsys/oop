package org.elsys.shapes;

import java.util.Collection;

public class ShapeContainer {
	
	/** 
	 * Adds a shape to the container.
	 * @param s the Shape to be added
	 * @return true if s was successfully added
	 */
	public boolean add(Shape s) {
		return false;
	}

	/**
	 * Adds all shapes to a container.
	 * @param shapes
	 * @return true if all shapes were added, false otherwise
	 */
	public boolean addAll(Collection<Shape> shapes) {
		return false;
	}

	/**
	 * Removes a shape from the container.
	 * @param s the Shape to be removed
	 * @return true if s was present in the collection
	 */
	public boolean remove(Shape s) {
		return false;
	}

	/**
	 * Returns the sum of the areas of all shapes in the container.
	 * @return
	 */
	public double getTotalArea() {
		return 0.0;
	}

	/**
	 *  Removes all shapes from the container.
	 */
	public void clear() {

	}

	/**
	 * Checks whether a Shape is present in the container.
	 * @param s the Shape to check
	 * @return true if s is present
	 */
	public boolean contains(Shape s) {
		return false;
	}

}
