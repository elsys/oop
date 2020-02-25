class Point {
  private double x;
  private double y;

  public Point() {
    x = 0;
    y = 0;
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point(double x) {
    this.x = x;
    y = 0;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public String toString() {
    return String.format("(%f, %f)", getX(), getY());
  }
}

class Main {
  public static void main(String[] args) {
    Point p0 = new Point();
    Point p1 = new Point(1, 2);
    Point p2 = new Point(1);

    System.out.println(p0.toString());
    System.out.println(p1.toString());
    System.out.println(p2.toString());
  }
}
