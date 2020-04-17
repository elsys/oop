package org.elsys.duzunov;

public class CarStore {
    /**
     * Adds the specified car in the store.
     * @return true if the car was added successfully to the store
     */
    public boolean add(Car car) {
    }

    /**
     * Adds all of the elements of the specified collection in the store.
     * @return true if the store cars are changed after the execution
     * (i.e. at least one new car is added to the store)
     */
    public boolean addAll(Collection<Car> cars) {
    }

    /**
     * Removes the specified car from the store.
     * @return true if the car is successfully removed from the store
     */
    public boolean remove(Car car) {
    }

    /**
     * Finds a car from the store by its registration number.
     * @throws CarNotFoundException if a car with this
     * registration number is not found in the store
     **/
    public Car getCarByRegistrationNumber(String registrationNumber)
            throws CarNotFoundException {
    }

    /**
     * Returns all cars of a given model.
     * The cars need to be sorted by year of manufacture (in ascending order).
     */
    public Collection<Car> getCarsByModel(Model model) {
    }

    /**
     * Returns all cars sorted by their natural ordering
     * (according to the implementation of the Comparable<Car> interface).
     **/
    public Collection<Car> getCars() {
    }

    /**
     * Returns all cars sorted according to the
     * order induced by the specified comparator.
     */
    public Collection<Car> getCars(Comparator<Car> comparator) {
    }

    /**
     * Returns all cars sorted according to the
     * given comparator and boolean flag for order.
     * @param isReversed if true, the cars should be returned in reverse order
     */
    public Collection<Car> getCars(Comparator<Car> comparator,
                                   boolean isReversed) {
    }

    /**
     * Returns the total number of cars in the store.
     */
    public int getNumberOfCars() {
    }

    /**
     * Returns the total price of all cars in the store.
     */
    public int getTotalPriceOfCars() {
    }
}
