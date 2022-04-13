package org.elsys.oop.shared;

public class Point {
    public int x = 0;
    public int y = 0;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(final Point p) {
        x = p.x;
        y = p.y;
    }

    public Point add(final Point p) {
        Point res = new Point(x + p.x, y + p.y);

        return res;
    }
}
