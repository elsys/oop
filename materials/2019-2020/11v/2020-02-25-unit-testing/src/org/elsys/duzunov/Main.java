package org.elsys.duzunov;

import org.elsys.duzunov.geometry.Point;
import org.elsys.duzunov.json.JsonEncoder;

public class Main {
    public static void main(String[] args) {
        System.out.println(JsonEncoder.encode(42));
        System.out.println(JsonEncoder.encode(0));
        System.out.println(JsonEncoder.encode(-42));

        System.out.println(JsonEncoder.encode(3.14159));
        System.out.println(JsonEncoder.encode(0.0));
        System.out.println(JsonEncoder.encode(-3.14));

        System.out.println(JsonEncoder.encode(true));
        System.out.println(JsonEncoder.encode(false));

        System.out.println(JsonEncoder.encode('a'));
        System.out.println(JsonEncoder.encode('y'));

        System.out.println(JsonEncoder.encode("foo"));
        System.out.println(JsonEncoder.encode("hello world"));

        Point point = new Point(1, 3.14);
        System.out.println(JsonEncoder.encode(point));

        int[] integers = new int[] { 1, 2, 42, -42 };
        System.out.println(JsonEncoder.encode(integers));

        double[] numbers = new double[] { 1.0, 2.0, 3.14159, -3.14 };
        System.out.println(JsonEncoder.encode(numbers));

        boolean[] booleans = new boolean[] { true, false, false, true };
        System.out.println(JsonEncoder.encode(booleans));

        char[] characters = new char[] { 'a', 'b', 'c', 'x', 'y', 'z' };
        System.out.println(JsonEncoder.encode(characters));

        String[] strings = new String[] { "foo", "hello world", "bar" };
        System.out.println(JsonEncoder.encode(strings));

        Point[] points = new Point[] { new Point(), new Point(42, -3.14) };
        System.out.println(JsonEncoder.encode(points));

        System.out.println((String) null);
    }
}
