public abstract class Shape extends Point {
    public Shape(int x, int y) {
        super(x, y);
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract Rectangle getBounds();
}
