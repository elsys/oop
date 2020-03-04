package test.java;

import main.java.Seagull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeagullTest {
    Seagull seagull = new Seagull();
    @Test
    void layEggs() {
        assertEquals("Laying Eggs!", seagull.layEggs());
    }

    @Test
    void fly() {
        assertEquals("I'm Flying!", seagull.fly());
    }
}