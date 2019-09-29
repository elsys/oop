package org.elsys.zoo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ZooTest {
    private Zoo zoo;

    @BeforeEach
    public void setUp() throws CantAddAnimalException {
        zoo = new Zoo();
        zoo.buildCell("Pandi", false, 3);
        Animal panda = new Animal("panda", "bear", AnimalType.Carnivore, false,3000);
        Animal panda2 = new Animal("kung fu panda", "bear", AnimalType.Carnivore, false,4500);
        Animal panda3 = new Animal("po", "bear", AnimalType.Carnivore, false,4000);
        zoo.addAnimal("Pandi", panda);
        zoo.addAnimal("Pandi", panda2);
        zoo.addAnimal("Pandi", panda3);
    }

    @Test
    void buildCell() throws CantAddAnimalException {
        zoo.buildCell("lions", false, 5);
        assertEquals(5, zoo.getSpaceLeftIn("lions"));
        Animal lion = new Animal("lion", "cat", AnimalType.Carnivore, false,1000);
        Animal lioness = new Animal("lioness", "cat", AnimalType.Carnivore, false,1000);
        zoo.addAnimal("lions", lion);
        zoo.addAnimal("lions", lioness);
        assertEquals(3, zoo.getSpaceLeftIn("lions"));
    }

    @Test
    public void testAddAnimalNoCapacityThrowsException() throws CantAddAnimalException {
        zoo.buildCell("Tigers", false, 1);
        Animal tiger = new Animal("tiger", "cat", AnimalType.Carnivore, false,6100);
        Animal tiger2 = new Animal("tiger2", "cat", AnimalType.Carnivore, false,6100);
        zoo.addAnimal("Tigers", tiger);
        assertThrows(CantAddAnimalException.class, () -> zoo.addAnimal("Tigers", tiger2));
    }

    @Test
    public void testAddAnimalHerbivoreInCarnivoresThrowsException() {
        Animal rabbit = new Animal("rabbit", "rabbit", AnimalType.Herbivore, false,40);
        assertThrows(CantAddAnimalException.class, () -> zoo.addAnimal("Pandi", rabbit));
    }

    @Test
    public void testAddAnimalWithPoolThrowsException() {
        Animal piranha = new Animal("Piranha", "fish", AnimalType.Carnivore, true,4);
        assertThrows(CantAddAnimalException.class, () -> { zoo.addAnimal("Pandi", piranha); });
    }

    @Test
    void possibleCellsFor() throws CantAddAnimalException {
        zoo.buildCell("Tigers", false, 2);
        Animal tiger = new Animal("tiger", "cat", AnimalType.Carnivore, false,6100);
        zoo.addAnimal("Tigers", tiger);

        Animal puma = new Animal("puma", "cat", AnimalType.Carnivore, false, 500);
        assertEquals(Arrays.asList("Tigers"), zoo.possibleCellsFor(puma));
    }

    @Test
    void hasAnimal() {
        Animal panda = new Animal("kung fu panda", "bear", AnimalType.Carnivore, false,4500);
        assertTrue(zoo.hasAnimal(panda));
    }

    @Test
    void getTotalSpaceLeft() throws CantAddAnimalException {
        zoo.buildCell("lions", false, 5);
        Animal lion = new Animal("lion", "cat", AnimalType.Carnivore, false,1000);
        Animal lioness = new Animal("lioness", "cat", AnimalType.Carnivore, false,1000);
        zoo.addAnimal("lions", lion);
        zoo.addAnimal("lions", lioness);
        assertEquals(3, zoo.getTotalSpaceLeft());
    }

    @Test
    void getSpaceLeft() throws CantAddAnimalException {
        zoo.buildCell("Tigers", false, 2);
        Animal tiger = new Animal("tiger", "cat", AnimalType.Carnivore, false,6100);
        zoo.addAnimal("Tigers", tiger);

        HashMap<String, Integer> spaceLeft = new HashMap<>();
        spaceLeft.put("Pandi", 0);
        spaceLeft.put("Tigers", 1);

        assertEquals(spaceLeft, zoo.getSpaceLeft());
    }

    @Test
    void getSpaceLeftIn() {
        assertEquals(0, zoo.getSpaceLeftIn("Pandi"));
    }
}