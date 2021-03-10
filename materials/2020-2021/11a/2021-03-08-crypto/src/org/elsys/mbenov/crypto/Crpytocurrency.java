package org.elsys.mbenov.crypto;

public abstract class Crpytocurrency {
    protected double price;
    private final double startingPrice;
    private final String name;

    public Crpytocurrency(double startingPrice, String name) {
        if(startingPrice <= 0) throw new IllegalArgumentException("Price too low");

        this.price = startingPrice;
        this.startingPrice = startingPrice;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public String getName() {
        return name;
    }

    public abstract void updatePrice(double sold, double bought);
}
