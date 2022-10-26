import static java.lang.Math.sqrt;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(Point[] points) {
        if(points.length != 3) {
            throw new IllegalArgumentException("Array of point must have 3 elements!");
        }
        a = points[0];
        b = points[1];
        c = points[2];
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public double getPerimeter() {
        double ab = a.getDistanceTo(b);
        double ac = a.getDistanceTo(c);
        double bc = b.getDistanceTo(c);
        return  ab + ac + bc;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        double ab = a.getDistanceTo(b);
        double ac = a.getDistanceTo(c);
        double bc = b.getDistanceTo(c);

        return sqrt(p * (p-ab) * (p-ac) * (p-bc));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
