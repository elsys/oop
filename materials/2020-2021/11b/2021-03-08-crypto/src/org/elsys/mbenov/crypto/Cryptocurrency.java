package org.elsys.mbenov.crypto;

public abstract class Cryptocurrency {
    protected String name;
    protected double basePrice;
    protected double price;

    public Cryptocurrency(String name, double basePrice) {
        if(name.length() < 4) throw new IllegalArgumentException("Name is too short");
        if(basePrice < 0) throw new IllegalArgumentException("Base price is too low");

        this.name = name;
        this.basePrice = basePrice;
        price = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Cryptocurrency{" +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", price=" + price +
                '}';
    }

    public abstract void updatePrice(double sold, double bought);
}
