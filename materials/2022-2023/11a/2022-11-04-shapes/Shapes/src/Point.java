public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public static double getSide(Point a, Point b)
    {
        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() + b.getY()), 2));
    }

    public static PointHoader max(Point a, Point b, Point c)
    {
        Point temp = a;
        PointHoader otherPoints = null;

        if(temp.getY() <= b.getY())
        {
            temp = b;
            otherPoints = new PointHoader(temp, a, c);
        }


        if(temp.getY() <= c.getY())
        {
            temp = c;
            otherPoints = new PointHoader(temp, b, a);
        }

        if(null == otherPoints)
            otherPoints = new PointHoader(temp, b, c);

        return otherPoints;
    }
}
