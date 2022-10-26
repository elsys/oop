public class Main {

    public static final String POINTS_SEPARATOR = ";";
    public static final String COORDINATE_SEPARATOR = ",";

    public static void main(String[] args) {
        Triangle triangles[] = new Triangle[args.length];
        for(int i = 0; i < args.length; i++) {
            String points = args[i];
            String[] trianglePoints = points.split(POINTS_SEPARATOR);
            triangles[i] = buildTriangle(trianglePoints);
        }

        for(Triangle t : triangles) {
            System.out.println(t);
        }
    }

    private static Triangle buildTriangle(String[] trianglePoints) {
        Point points[] = new Point[3];
        for(int i = 0; i < 3; i++) {
            String point = trianglePoints[i];
            String[] coordinates = point.split(COORDINATE_SEPARATOR);
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            points[i] = new Point(x, y);
        }

        return new Triangle(points);
    }

    public static Triangle getBiggestArea(Triangle[] triangles) {
        Triangle biggestTriangle = triangles[0];
        for(Triangle triangle : triangles) {
            if(biggestTriangle.getArea() > biggestTriangle.getArea()) {
                biggestTriangle = triangle;
            }
        }

        return biggestTriangle;
    }

    public static Triangle getBiggestPerimeter(Triangle[] triangles) {
        Triangle biggestTriangle = triangles[0];
        for(Triangle triangle : triangles) {
            if(biggestTriangle.getPerimeter() > biggestTriangle.getPerimeter()) {
                biggestTriangle = triangle;
            }
        }

        return biggestTriangle;
    }

    public static Triangle getSmallestArea(Triangle[] triangles) {
        Triangle smallestTriangle = triangles[0];
        for(Triangle triangle : triangles) {
            if(smallestTriangle.getArea() < smallestTriangle.getArea()) {
                smallestTriangle = triangle;
            }
        }

        return smallestTriangle;
    }

    public static Triangle getSmallestPerimeter(Triangle[] triangles) {
        Triangle smallestTriangle = triangles[0];
        for(Triangle triangle : triangles) {
            if(smallestTriangle.getPerimeter() < smallestTriangle.getPerimeter()) {
                smallestTriangle = triangle;
            }
        }

        return smallestTriangle;
    }
}