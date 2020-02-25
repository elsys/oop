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
