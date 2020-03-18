package test.com.oop;

import main.java.com.oop.Point;
import main.java.com.oop.Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private Rectangle r;

    @BeforeEach
    void setUp() {
        Point A = new Point(0, 0);
        Point B = new Point(3, 3);

        this.r = new Rectangle(A, B);
    }

    @Test
    void getPerimeter() {
        assertEquals(this.r.getPerimeter(), 12);
    }

    @Test
    void getArea() {
        assertEquals(this.r.getArea(), 9);
    }
}