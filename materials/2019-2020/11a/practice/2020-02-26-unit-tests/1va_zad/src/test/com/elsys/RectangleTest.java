package test.com.elsys;

import main.java.com.elsys.Point;
import main.java.com.elsys.Rectangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPerimeter() {

        Point A2 = new Point(0,0);
        Point B2 = new Point(2,2);

        BigDecimal expected = new BigDecimal(8).setScale(2);
        Rectangle r1 = new Rectangle(A2, B2);
        BigDecimal result = new BigDecimal(r1.getPerimeter()).setScale(2);

        assertEquals(expected, result);

    }

    @Test
    public void getArea() {
        Point A2 = new Point(0,0);
        Point B2 = new Point(2,2);

        BigDecimal expected = new BigDecimal(4).setScale(2);
        Rectangle r1 = new Rectangle(A2, B2);
        BigDecimal result = new BigDecimal(r1.getArea()).setScale(2);

        assertEquals(expected, result);
    }
}
