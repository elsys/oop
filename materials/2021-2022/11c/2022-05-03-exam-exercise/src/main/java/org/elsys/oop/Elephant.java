package org.elsys.oop;

public class Elephant extends Animal {
    private boolean isPregnant;

    public Elephant(float weight, boolean isPregnant) {
        super("Elephant", weight);

        this.isPregnant = isPregnant;
    }

    @Override
    public float getNeededFood() {
        return isPregnant ? 200 : 100;
    }

    @Override
    public String toString() {
        return species +
                " weight=" + weight +
                ", isPregnant=" + isPregnant;
    }
}
