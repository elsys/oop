package org.elsys.oop;

import static org.junit.jupiter.api.Assertions.*;

class ElephantTest {

    @org.junit.jupiter.api.Test
    void getNeededFood() {
        Animal elephant = new Elephant(10, false);
        assertEquals(100f, elephant.getNeededFood());

        elephant = new Elephant(10, true);
        assertEquals(200f, elephant.getNeededFood());
    }
}