package test.com.oop;

import main.java.com.oop.Point;
import main.java.com.oop.Triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private Triangle t;

    @BeforeEach
    void setUp() {
        Point A = new Point(0, 0);
        Point B = new Point(0, 3);
        Point C = new Point(4, 0);

        this.t = new Triangle(A, B, C);
    }

    @Test
    void getPerimeter() {
        assertEquals(this.t.getPerimeter(), 12);
    }

    @Test
    void getArea() {
        assertEquals(this.t.getArea(), 6);
    }
}