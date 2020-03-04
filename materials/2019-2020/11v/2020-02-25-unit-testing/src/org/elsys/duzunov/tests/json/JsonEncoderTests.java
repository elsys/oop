package org.elsys.duzunov.tests.json;

import org.elsys.duzunov.geometry.Point;
import org.elsys.duzunov.json.JsonEncoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JSON Encoder")
public class JsonEncoderTests {
    @Test
    @DisplayName("encodes int values")
    public void encodesInt() {
        Assertions.assertEquals("42", JsonEncoder.encode(42));
        Assertions.assertEquals("0", JsonEncoder.encode(0));
        Assertions.assertEquals("-42", JsonEncoder.encode(-42));
    }

    @Test
    @DisplayName("encodes double values")
    public void encodesDouble() {
        Assertions.assertEquals("3.141590", JsonEncoder.encode(3.14159));
        Assertions.assertEquals("0.000000", JsonEncoder.encode(0.0));
        Assertions.assertEquals("-3.140000", JsonEncoder.encode(-3.14));
    }

    @Test
    @DisplayName("encodes boolean values")
    public void encodesBoolean() {
        Assertions.assertEquals("true", JsonEncoder.encode(true));
        Assertions.assertEquals("false", JsonEncoder.encode(false));
    }

    @Test
    @DisplayName("encodes char values")
    public void encodesChar() {
        Assertions.assertEquals("\"a\"", JsonEncoder.encode('a'));
        Assertions.assertEquals("\"y\"", JsonEncoder.encode('y'));
    }

    @Test
    @DisplayName("encodes String values")
    public void encodesString() {
        Assertions.assertEquals("\"foo\"", JsonEncoder.encode("foo"));
        Assertions.assertEquals("\"hello world\"", JsonEncoder.encode("hello world"));
        Assertions.assertEquals("\"1\"", JsonEncoder.encode("1"));
        Assertions.assertEquals("\"\"", JsonEncoder.encode(""));
    }

    @Test
    @DisplayName("encodes Point values")
    public void encodesPoint() {
        Assertions.assertEquals("{ \"x\": 0.000000, \"y\": 0.000000 }", JsonEncoder.encode(new Point()));
        Assertions.assertEquals("{ \"x\": 42.000000, \"y\": -3.140000 }", JsonEncoder.encode(new Point(42, -3.14)));
    }

    @Test
    @DisplayName("encodes an array of int values")
    public void encodesIntArray() {
        int[] empty = new int[] {};
        Assertions.assertEquals("[]", JsonEncoder.encode(empty));

        int[] integers = new int[] { 1, 2, 42, -42 };
        Assertions.assertEquals("[1, 2, 42, -42]", JsonEncoder.encode(integers));
    }

    @Test
    @DisplayName("encodes an array of double values")
    public void encodesDoubleArray() {
        double[] empty = new double[] {};
        Assertions.assertEquals("[]", JsonEncoder.encode(empty));

        double[] numbers = new double[] { 1.0, 2.0, 3.14159, -3.14 };
        Assertions.assertEquals("[1.000000, 2.000000, 3.141590, -3.140000]", JsonEncoder.encode(numbers));
    }

    @Test
    @DisplayName("encodes an array of boolean values")
    public void encodesBooleanArray() {
        boolean[] empty = new boolean[] {};
        Assertions.assertEquals("[]", JsonEncoder.encode(empty));

        boolean[] booleans = new boolean[] { true, false, false, true };
        Assertions.assertEquals("[true, false, false, true]", JsonEncoder.encode(booleans));
    }

    @Test
    @DisplayName("encodes an array of char values")
    public void encodesCharArray() {
        char[] empty = new char[] {};
        Assertions.assertEquals("[]", JsonEncoder.encode(empty));

        char[] characters = new char[] { 'a', 'b', 'c', 'x', 'y', 'z' };
        Assertions.assertEquals("[\"a\", \"b\", \"c\", \"x\", \"y\", \"z\"]", JsonEncoder.encode(characters));
    }

    @Test
    @DisplayName("encodes an array of String values")
    public void encodesStringArray() {
        String[] empty = new String[] {};
        Assertions.assertEquals("[]", JsonEncoder.encode(empty));

        String[] strings = new String[] { "foo", "", "hello world", "bar" };
        Assertions.assertEquals("[\"foo\", \"\", \"hello world\", \"bar\"]", JsonEncoder.encode(strings));
    }

    @Test
    @DisplayName("encodes an array of Point values")
    public void encodesPointArray() {
        Point[] empty = new Point[] {};
        Assertions.assertEquals("[]", JsonEncoder.encode(empty));

        Point[] points = new Point[] { new Point(), new Point(42, -3.14) };
        Assertions.assertEquals("[{ \"x\": 0.000000, \"y\": 0.000000 }, { \"x\": 42.000000, \"y\": -3.140000 }]", JsonEncoder.encode(points));
    }

    @Test
    @DisplayName("encodes null values")
    public void encodesNull() {
        Assertions.assertEquals("null", JsonEncoder.encode((String) null));
        Assertions.assertEquals("null", JsonEncoder.encode((Point) null));
        Assertions.assertEquals("null", JsonEncoder.encode((int[]) null));
        Assertions.assertEquals("null", JsonEncoder.encode((double[]) null));
        Assertions.assertEquals("null", JsonEncoder.encode((boolean[]) null));
        Assertions.assertEquals("null", JsonEncoder.encode((char[]) null));
        Assertions.assertEquals("null", JsonEncoder.encode((String[]) null));
        Assertions.assertEquals("null", JsonEncoder.encode((Point[]) null));
    }
}
