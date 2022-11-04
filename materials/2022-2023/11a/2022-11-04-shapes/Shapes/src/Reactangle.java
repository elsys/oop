public class Reactangle implements Shape, HasHeight{
    private Point a;
    private Point b;

    public Reactangle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double getHeight() {
        return Math.abs(a.getY() - b.getY());
    }
    @Override
    public double getPerimeter() {
        return 2 * (getHeight() + getWidth());
    }
    @Override
    public double getArea() {
        return getHeight() * getWidth();
    }
    private double getWidth()
    {
        return Math.abs(b.getX() - a.getX());
    }
}
