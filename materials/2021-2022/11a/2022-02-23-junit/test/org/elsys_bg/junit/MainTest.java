package org.elsys_bg.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;
    @BeforeAll // executes before all tests
    public static void before() {

    }

    @BeforeEach //executes before every test
    public void setUp() {
        main = new Main();
    }

    @AfterAll
    public static void after() {

    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void test_sum() {
        int result = main.sum(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void test_mul() {
        int result = main.mul(2, 3);
        assertEquals(6, result);
    }
}