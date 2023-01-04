package org.elsys_bg.classes;

public class Point {
    private int x;
    private int y;

    private Point() {

    }

    public static final class PointBuilder {
        private int x;
        private int y;

        private PointBuilder() {
        }

        public static PointBuilder aPoint() {
            return new PointBuilder();
        }

        public PointBuilder withX(int x) {
            this.x = x;
            return this;
        }

        public PointBuilder withY(int y) {
            this.y = y;
            return this;
        }

        public Point build() {
            Point point = new Point();
            point.y = this.y;
            point.x = this.x;
            return point;
        }
    }
}
