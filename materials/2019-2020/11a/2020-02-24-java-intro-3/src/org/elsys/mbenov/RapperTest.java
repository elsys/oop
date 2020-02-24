package org.elsys.mbenov;

import static org.junit.jupiter.api.Assertions.*;

class RapperTest {

    Rapper instance;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        instance = new Rapper();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void increment() {
    }

    @org.junit.jupiter.api.Test
    void getCount() {
        assertEquals(1, Rapper.getCount());
    }

    @org.junit.jupiter.api.Test
    void getEarnings() {
    }
}