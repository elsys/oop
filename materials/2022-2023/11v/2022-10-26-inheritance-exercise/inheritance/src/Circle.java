public class Circle extends Shape {
    protected int r;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, r*2, r*2);
    }
}
