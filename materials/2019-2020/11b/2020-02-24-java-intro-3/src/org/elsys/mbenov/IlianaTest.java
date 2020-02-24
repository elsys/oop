package org.elsys.mbenov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IlianaTest {

    Iliana instance;

    @BeforeEach
    void setUp() {
        instance = new Iliana();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCount() {
        assertEquals(1, Iliana.getCount());
    }

    @Test
    void increment() {
    }

    @Test
    void getAge() {
    }
}