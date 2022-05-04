package org.elsys.oop;

public class Cow extends Animal {
    public Cow(float weight) {
        super("Cow", weight);
    }

    @Override
    public float getNeededFood() {
        return weight * 10;
    }
}
