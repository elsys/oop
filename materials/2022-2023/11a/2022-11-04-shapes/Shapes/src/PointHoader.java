public class PointHoader {
    private Point a;
    private Point otherPoints [];

    public PointHoader(Point a, Point b, Point c)
    {
        this.a = a;
        this.otherPoints[0] = b;
        this.otherPoints[1] = c;
    }


    public Point[] getOtherPoints() {
        return otherPoints;
    }

    public void setOtherPoints(Point[] otherPoints) {
        this.otherPoints = otherPoints;
    }
}
