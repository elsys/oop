public class Circle implements Shape{
    private int radius;
    Point center;

    public Circle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
