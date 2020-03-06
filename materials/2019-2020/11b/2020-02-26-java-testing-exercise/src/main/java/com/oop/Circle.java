package main.java.com.oop;

public class Circle {
    private final Point center;
    private final double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void printShape() {
        System.out.println("Circle");
        System.out.println("Center = (" + center.getX() + ", " + center.getY() + ")");
        System.out.println("Radius = " + radius);
        System.out.println();
        System.out.println("Perimeter = " + this.getPerimeter());
        System.out.println("Area = " + this.getArea());
    }
}
