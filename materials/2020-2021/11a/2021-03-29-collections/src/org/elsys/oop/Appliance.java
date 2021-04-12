package org.elsys.oop;

import java.util.Comparator;

public class Appliance implements Comparable<Appliance> {
    public static class ComparePower implements Comparator<Appliance> {
        @Override
        public int compare(Appliance o1, Appliance o2) {
            return o1.power - o2.power;
        }
    }

    String brand;
    float price;
    int power;

    public Appliance(String brand, float price, int power) {
        this.brand = brand;
        this.price = price;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", power=" + power +
                '}';
    }

    @Override
    public int compareTo(Appliance o) {
        if(price > o.price) return -1;
        if(price < o.price) return 1;

        return brand.compareTo(o.brand);

//        return 0;
    }
}
