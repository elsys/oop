package test.java;

import main.java.Mammal;
import main.java.Whale;

import static org.junit.jupiter.api.Assertions.*;

class WhaleTest {

    @org.junit.jupiter.api.Test
    void giveBirth() {
        Whale whale = new Whale();
        assertEquals("Giving Birth!", whale.giveBirth());
    }

    @org.junit.jupiter.api.Test
    void swim() {
        Whale whale = new Whale();
        assertEquals("I'm Swimming!", whale.swim());
    }
}