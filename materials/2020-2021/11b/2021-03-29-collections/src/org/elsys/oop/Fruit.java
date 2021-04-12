package org.elsys.oop;

import java.util.Comparator;

public class Fruit implements Comparable {
    float price;
    float weight;
    String name;

    public Fruit(float price, float weight, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Fruit)) throw new IllegalArgumentException();

        Fruit other = (Fruit)o;

        if(price > other.price) return 1;
        if(price < other.price) return -1;

        return name.compareTo(other.name);
    }

    public static class CompareWeights implements Comparator<Fruit> {
        @Override
        public int compare(Fruit o1, Fruit o2) {
            if(o1.weight > o2.weight) return 1;
            if(o1.weight < o2.weight) return -1;

            return 0;
        }
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "price=" + price +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
