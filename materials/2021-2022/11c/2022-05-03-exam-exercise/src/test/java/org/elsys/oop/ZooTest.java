package org.elsys.oop;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ZooTest {

    @org.junit.jupiter.api.Test
    void getNeededFood() {
        Zoo z = new Zoo();
        assertEquals(0, z.getNeededFood());

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cow(10));
        animals.add(new Cow(15));
        z = new Zoo(animals);
        assertEquals(250, z.getNeededFood());
    }
}