class Point {
  public double x;
  public double y;
}

class ShowPoint {
  public static void main(String[] args) {
    Point point1 = new Point();
    point1.x = 3;
    point1.y = 4;

    Point point3 = new Point();
    point3.x = point1.x;
    point3.y = point1.y;

    Point point2 = point1;
    point2.y = 42;

    System.out.println("point1.x = " + point1.x); // 3
    System.out.println("point1.y = " + point1.y); // 42

    System.out.println("point2.x = " + point2.x); // 3
    System.out.println("point2.y = " + point2.y); // 42

    System.out.println("point3.x = " + point3.x); // 3
    System.out.println("point3.y = " + point3.y); // 4
  }
}
