public class Rectangle extends Shape implements IWithPoints {
    protected int a;
    protected int b;

    public Rectangle(int x, int y, int a, int b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, a, b);
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{
                new Point(x - a / 2, y - b / 2),
                new Point(x + a / 2, y - b / 2),
                new Point(x - a / 2, y + b / 2),
                new Point(x + a / 2, y + b / 2),
        };
    }
}
