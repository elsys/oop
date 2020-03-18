package main.java.com.oop;

public class Rectangle {
    private final Point p1;
    private final Point p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getPerimeter() {
        double s1 = Math.abs(p1.getX() - p2.getX());
        double s2 = Math.abs(p1.getY() - p2.getY());

        return (s1 + s2) * 2;
    }

    public double getArea() {
        double s1 = Math.abs(p1.getX() - p2.getX());
        double s2 = Math.abs(p1.getY() - p2.getY());

        return s1*s2;
    }

    public void printShape() {
        double s1 = Math.abs(p1.getX() - p2.getX());
        double s2 = Math.abs(p1.getY() - p2.getY());

        System.out.println("Triangle");
        System.out.println("AB = CD = " + s1);
        System.out.println("BC = AD = " + s2);
        System.out.println();
        System.out.println("Perimeter = " + this.getPerimeter());
        System.out.println("Area = " + this.getArea());
    }
}
