package org.elsys.oop;

public abstract class Animal {
    protected String species;
    protected float weight;

    public Animal(String species, float weight) {
        this.species = species;
        this.weight = weight;
    }

    public abstract float getNeededFood();


    @Override
    public String toString() {
        return species +
                " weight=" + weight;
    }
}
