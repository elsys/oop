package test.java;

import main.java.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal = new Animal("Sharo", 12);
    @Test
    void sayName() {
        assertEquals("Sharo", animal.sayName());
    }
}