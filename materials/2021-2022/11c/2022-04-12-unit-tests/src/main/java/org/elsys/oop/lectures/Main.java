package org.elsys.oop.lectures;

//import org.elsys.oop.shared.Point;
import org.elsys.oop.shared.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main 1");

        Point p1 = new Point();
        Point p2 = new Point(3, 5);
        Point p3 = p1.add(p2);

        System.out.println(p1.x + " " + p1.y);
        System.out.println(p2.x + " " + p2.y);
        System.out.println(p3.x + " " + p3.y);
    }
}
