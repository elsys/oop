package org.elsys.oop.shared;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

class PointTest {
    int myCommonVar;

    @BeforeEach
    void setUp() {
        myCommonVar = 4;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void defaultConstructor() {
        Point testPoint = new Point();

        assertEquals(0, testPoint.x);
        Assertions.assertEquals(0, testPoint.y);
    }

    @Test
    void add() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, myCommonVar);
        Point point3 = point1.add(point2);

        assertEquals(4, point3.x);
        assertEquals(6, point3.y);
        assertNotEquals(point1, point3);
    }
}