public class Triangle implements Shape, HasHeight {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getPerimeter()
    {
        return Point.getSide(a, b) + Point.getSide(a, c) + Point.getSide(b, c);
    }
    public double getArea()
    {
        double halfPerimeter = getPerimeter() / 2;

        return Math.sqrt(halfPerimeter *
                (halfPerimeter - Point.getSide(a, b) *
                        (halfPerimeter - Point.getSide(a, c) *
                                (halfPerimeter - Point.getSide(b, c)))));
    }
    public double getHeight()
    {
        PointHoader temp = Point.max(a, b, c);

        return getArea() / 2 * Point.getSide(temp.getOtherPoints()[0], temp.getOtherPoints()[1]);
    }
}
