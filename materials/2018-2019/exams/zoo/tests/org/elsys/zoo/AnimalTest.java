package org.elsys.zoo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    private Animal bear;

    @BeforeEach
    void setUp() {
        bear = new Animal("panda", "bear", AnimalType.Carnivore, true, 1000);
    }

    @Test
    public void testGetName(){
        assertEquals("panda", bear.getName());
    }

    @Test
    public void testGetKind(){
        assertEquals("bear", bear.getKind());
    }

    @Test
    public void testGetType(){
        assertEquals(AnimalType.Carnivore, bear.getType());
    }

    @Test
    public void testNeedsPool(){
        assertTrue(bear.isNeedsPool());
    }

    @Test void testGetMonthlyCost(){
        assertEquals(1000, bear.getMonthlyCost());
    }

}