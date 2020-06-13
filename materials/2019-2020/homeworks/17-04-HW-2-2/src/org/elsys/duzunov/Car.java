package org.elsys.duzunov;

import java.util.HashMap;
import java.util.Random;

public abstract class Car implements Comparable<Car> {
    private static final HashMap<Region, Integer> carNumberByRegion =
            new HashMap<>();

    static {
        for (Region region : Region.values()) {
            carNumberByRegion.put(region, 999);
        }
    }

    private final Model model;
    private final int year;
    private final int price;
    private final EngineType engineType;
    private final String registrationNumber;

    public Car(Model model,
               int year,
               int price,
               EngineType engineType,
               Region region) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber(region);
    }

    /**
     * Returns the model of the car.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Returns the year of manufacture of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the price of the car.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the engine type of the car.
     */
    public EngineType getEngineType() {
        return engineType;
    }

    /**
     * Returns the unique registration number of the car.
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public int compareTo(Car other) {
        int modelComparisonResult = this.getModel().compareTo(other.getModel());

        return modelComparisonResult == 0 ?
                Integer.compare(this.getYear(), other.getYear()) :
                modelComparisonResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getRegistrationNumber().equals(car.getRegistrationNumber());
    }

    @Override
    public int hashCode() {
        return getRegistrationNumber().hashCode();
    }

    private String generateRegistrationNumber(Region region) {
        return String.format(
                "%s%d%c%c",
                region.getPrefix(),
                carNumberByRegion.merge(region, 1, Integer::sum),
                randomUppercaseAlphabeticCharacter(),
                randomUppercaseAlphabeticCharacter()
        );
    }

    private char randomUppercaseAlphabeticCharacter() {
        return (char) (new Random().nextInt('Z' - 'A' + 1) + 'A');
    }
}
