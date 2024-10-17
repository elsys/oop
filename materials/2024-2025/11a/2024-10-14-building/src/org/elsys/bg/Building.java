package org.elsys.bg;

import java.util.List;

public abstract class Building implements HasArea {
    private String address;
    private List<Place> places;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.isEmpty())
            throw new IllegalArgumentException("Address cannot be empty");
        this.address = address;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        if (places.isEmpty())
            throw new IllegalArgumentException("Places cannot be empty");
        this.places = places;
    }

    public double calculateTotalArea() {
        double total = 0;
        for (Place place : places) {
            total += place.getArea();
        }
        return total;
    }

    public abstract double getPricePerMonth();

    public double estimateReturn(int months) {
        return months * getPricePerMonth() * calculateTotalArea();
    }

    public abstract double estimateExpenses(int months);

    public double estimateNetReturn(int months) {
        return estimateReturn(months) - estimateExpenses(months);
    }
}
