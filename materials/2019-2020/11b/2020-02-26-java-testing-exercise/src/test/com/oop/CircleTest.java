package test.com.oop;

import main.java.com.oop.Circle;
import main.java.com.oop.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    private Circle c;

    @BeforeEach
    void setUp() {
        Point A = new Point(0, 0);
        double radius = 5;

        this.c = new Circle(A, radius);
    }

    @Test
    void getPerimeter() {
        assertEquals(this.c.getPerimeter(), Math.PI * this.c.getRadius() * 2);
    }

    @Test
    void getArea() {
        assertEquals(this.c.getArea(), Math.PI * Math.pow(this.c.getRadius(), 2));
    }
}