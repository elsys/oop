package org.elsys.oop;

import static org.junit.jupiter.api.Assertions.*;

class CowTest {

    @org.junit.jupiter.api.Test
    void getNeededFood() {
        Animal cow = new Cow(10);

        assertEquals(100f, cow.getNeededFood());
    }
}