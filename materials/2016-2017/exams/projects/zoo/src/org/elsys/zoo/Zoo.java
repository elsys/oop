package org.elsys.zoo;

import java.util.Collection;

public class Zoo {

	/**
	 * Creates new zoo with the given capacity and food capacity.
	 * 
	 * It's impossible to add new animals when there is not enough capacity in
	 * the zoo or when the budget for food per day (a.k.a. food capacity will be
	 * exceeded).
	 * 
	 * @param capacity
	 * @param foodPerDayCapacity
	 */
	public Zoo(int capacity, double foodPerDayCapacity) {

	}

	/**
	 * Returns the capacity of the zoo.
	 * 
	 * @return
	 */
	public int getCapacity() {
		return 0;
	}

	/**
	 * Returns the amount of food per day that the zoo can provide.
	 * 
	 * @return
	 */
	public double getFoodPerDayCapacity() {
		return 0.0;
	}

	/**
	 * Adds an animal to the zoo.
	 * 
	 * Returns false if you try to add a null reference.
	 * 
	 * @throws NotEnoughCapacityException
	 *             if the capacity of the zoo is reached or if the food capacity
	 *             of the zoo is reached.
	 * 
	 * @param a
	 *            the Animal to be added
	 * @return true if a was successfully added
	 */
	public boolean add(Animal a) {
		return false;
	}

	/**
	 * Adds all animals to a zoo.
	 * 
	 * @param animals
	 * @return true if all animals were added, false otherwise
	 */
	public boolean addAll(Collection<Animal> animals) {
		return false;
	}

	/**
	 * Returns a collection with all animals currently living in the zoo.
	 * 
	 * @return
	 */
	public Collection<Animal> getAnimals() {
		return null;
	}

	/**
	 * Removes an animal from the zoo.
	 * 
	 * @param a
	 *            the Animal to be removed
	 * @return true if a was present in the collection
	 */
	public boolean remove(Animal s) {
		return false;
	}

	/**
	 * Returns the total amount of food that the animals eat per day.
	 * 
	 * @return
	 */
	public double getCurrentFoodPerDayAmount() {
		return 0.0;
	}

	/**
	 * Closes the zoo; removes all animals from the zoo.
	 */
	public void close() {

	}

	/**
	 * Checks whether an animal is present in the zoo.
	 * 
	 * @param a
	 *            the Animal to check
	 * @return true if a is present
	 */
	public boolean contains(Animal a) {
		return false;
	}

}
