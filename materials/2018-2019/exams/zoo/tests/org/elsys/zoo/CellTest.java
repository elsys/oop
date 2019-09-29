package org.elsys.zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell cell;


    @BeforeEach
    void setup() throws CantAddAnimalException {
        Animal panda = new Animal("panda", "bear", AnimalType.Carnivore, false,3000);
        Animal panda2 = new Animal("kung fu panda", "bear", AnimalType.Carnivore, false,4500);
        Animal panda3 = new Animal("po", "bear", AnimalType.Carnivore, false,4000);
        cell = new Cell(5, false);
        cell.addAnimal(panda);
        cell.addAnimal(panda2);
        cell.addAnimal(panda3);
    }

    @Test
    void getHasPool() {
        assertFalse(cell.getHasPool());
    }

    @Test
    void addAnimal() {
        Animal herbivore = new Animal("Micky", "mouse", AnimalType.Herbivore, false, 3000);
        Assertions.assertThrows(CantAddAnimalException.class, () -> cell.addAnimal(herbivore));
        cell.addAnimal(new Animal("po1", "bear", AnimalType.Carnivore, false, 4000));
        cell.addAnimal(new Animal("po2", "bear", AnimalType.Carnivore, false, 4000));
        Assertions.assertThrows(CantAddAnimalException.class,
                () -> cell.addAnimal(new Animal("po3", "bear", AnimalType.Carnivore, false, 4000)));
    }

    @Test
    void hasAnimal() {
        Animal panda = new Animal("kung fu panda", "bear", AnimalType.Carnivore, false,4500);
        assertTrue(cell.hasAnimal(panda));
    }
}