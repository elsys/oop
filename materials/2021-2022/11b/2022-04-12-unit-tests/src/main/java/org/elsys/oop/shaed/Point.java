package org.elsys.oop.shaed;

public class Point {
    public int x;
    public int y = 0;

    public Point() {
        x = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(final Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public Point add(Point p) {
        Point res = new Point(x + p.x, y + p.y);

        return res;
    }
}
