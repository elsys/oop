package org.elsys.oop.shaed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Assertions;

class PointTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void defaultConstructor() {
        Point testPoint = new Point();

        assertEquals(0, testPoint.x);
        assertEquals(0, testPoint.y);

//        assertArrayEquals(
//                new float[]{1,2,3},
//                new float[]{1,2, 4}
//        );
    }

    @Test
    void add() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = p1.add(p2);

        assertEquals(4, p3.x);
        assertEquals(6, p3.y);

        assertNotEquals(p1, p3);

        assertEquals(1, p1.x);
        assertEquals(2, p1.y);
    }
}