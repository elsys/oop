package org.elsys.duzunov;

public <type> Car {
    /**
     * Returns the model of the car.
     */
    public Model getModel();

    /**
     * Returns the year of manufacture of the car.
     */
    public int getYear();

    /**
     * Returns the price of the car.
     */
    public int getPrice();

    /**
     * Returns the engine type of the car.
     */
    public EngineType getEngineType();

    /**
     * Returns the unique registration number of the car.
     */
    public String getRegistrationNumber();
}
