package test.com.elsys;

import main.java.com.elsys.Point;
import main.java.com.elsys.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPerimeter() {
        Point A1= new Point(0, 0);
        Point B1= new Point(0, 3);
        Point C1= new Point(4, 3);

        BigDecimal expected = new BigDecimal(12).setScale(2);
        Triangle t1= new Triangle(A1, B1, C1);
        BigDecimal result = new BigDecimal(t1.getPerimeter()).setScale(2);

        assertEquals(expected, result);


    }

    @Test
    public void getArea() {
        Point A1= new Point(0, 0);
        Point B1= new Point(0, 3);
        Point C1= new Point(4, 3);
        BigDecimal expected = new BigDecimal(6).setScale(2);
        Triangle t1= new Triangle(A1, B1, C1);
        BigDecimal result = new BigDecimal(t1.getArea()).setScale(2);

        assertEquals(expected, result);

    }
}
