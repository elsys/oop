package org.elsys.duzunov;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class CarStore {
    public static class CarNotFoundException extends Exception {}

    TreeSet<Car> cars = new TreeSet<>();
    private int totalPrice = 0;

    /**
     * Adds the specified car in the store.
     * @return true if the car was added successfully to the store
     */
    public boolean add(Car car) {
        boolean hasAddedSuccessfully = cars.add(car);
        if (hasAddedSuccessfully) {
            totalPrice += car.getPrice();
        }

        return hasAddedSuccessfully;
    }

    /**
     * Adds all of the elements of the specified collection in the store.
     * @return true if the store cars are changed after the execution
     * (i.e. at least one new car is added to the store)
     */
    public boolean addAll(Collection<Car> cars) {
        boolean hasAddedSuccessfully = false;
        for (Car car : cars) {
            if (add(car)) {
                hasAddedSuccessfully = true;
            }
        }

        return hasAddedSuccessfully;
    }

    /**
     * Removes the specified car from the store.
     * @return true if the car is successfully removed from the store
     */
    public boolean remove(Car car) {
        boolean hasRemovedSuccessfully = cars.remove(car);
        if (hasRemovedSuccessfully) {
            totalPrice -= car.getPrice();
        }

        return hasRemovedSuccessfully;
    }

    /**
     * Finds a car from the store by its registration number.
     * @throws CarNotFoundException if a car with this
     * registration number is not found in the store
     **/
    public Car getCarByRegistrationNumber(String registrationNumber)
            throws CarNotFoundException {
        for (Car car : cars) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                return car;
            }
        }

        throw new CarNotFoundException();
    }

    /**
     * Returns all cars of a given model.
     * The cars need to be sorted by year of manufacture (in ascending order).
     */
    public Collection<Car> getCarsByModel(Model model) {
        TreeSet<Car> carsByModel = new TreeSet<>();
        for (Car car : cars) {
            if (car.getModel() == model) {
                carsByModel.add(car);
            }
        }

        return carsByModel;
    }

    /**
     * Returns all cars sorted by their natural ordering
     * (according to the implementation of the Comparable<Car> interface).
     **/
    public Collection<Car> getCars() {
        return cars;
    }

    /**
     * Returns all cars sorted according to the
     * order induced by the specified comparator.
     */
    public Collection<Car> getCars(Comparator<Car> comparator) {
        TreeSet<Car> carsByComparator = new TreeSet<>(comparator);
        carsByComparator.addAll(cars);

        return carsByComparator;
    }

    /**
     * Returns all cars sorted according to the
     * given comparator and boolean flag for order.
     * @param isReversed if true, the cars should be returned in reverse order
     */
    public Collection<Car> getCars(Comparator<Car> comparator,
                                   boolean isReversed) {
        if (isReversed) {
            return getCars(comparator.reversed());
        }

        return getCars(comparator);
    }

    /**
     * Returns the total number of cars in the store.
     */
    public int getNumberOfCars() {
        return cars.size();
    }

    /**
     * Returns the total price of all cars in the store.
     */
    public int getTotalPriceOfCars() {
        return totalPrice;
    }
}
