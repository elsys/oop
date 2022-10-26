public class Main {
    private static void printShape(Shape s) {
        Rectangle bounds = s.getBounds();

        System.out.println(s);
        System.out.println("S=" + s.getArea() + " P=" + s.getPerimeter());
        for (Point p : bounds.getPoints())
            // Note: Point coordinates are ints and you can expect some rounding
            System.out.printf("(" + p.getX() + "," + p.getY() + ") ");

        System.out.println("");
    }

    public static void main(String[] args) {
        Square s1 = new Square(0, 0, 3);
        Square s2 = new Square(5, 10, 4);
        Rectangle r1 = new Rectangle(0, 0, 5, 6);
        Circle c1 = new Circle(0, 0, 8);

        printShape(s1);
        printShape(s2);
        printShape(r1);
        printShape(c1);
    }
}