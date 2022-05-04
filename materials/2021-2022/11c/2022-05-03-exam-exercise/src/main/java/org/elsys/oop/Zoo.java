package org.elsys.oop;

import java.util.LinkedList;
import java.util.List;

public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        this(new LinkedList<Animal>());
    }

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public float getNeededFood() {
        float food = 0f;

        for(Animal a : animals) {
            food += a.getNeededFood();
        }

        return food;
    }

    public static void main(String[] args) {
        Zoo z = new Zoo();
    }
}
