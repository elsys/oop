#include <iostream>
#include <cmath>

using namespace std;

class Point {
  double x;
  double y;

public:
  Point(): x(0), y(0) {}

  Point(double x, double y): x(x), y(y) {}

  double get_x() {
    return x;
  }

  double get_y() {
    return y;
  }

  double distance_to(Point other) {
    double dx = get_x() - other.get_x();
    double dy = get_y() - other.get_y();

    return sqrt(dx * dx + dy * dy);
  }

  Point add(Point other) {
    return Point(get_x() + other.get_x(), get_y() + other.get_y());
  }

  void print() {
    cout << '(' << get_x() << ", " << get_y() << ")\n";
  }
};

int main() {
  Point p(2, 3);

  Point* pp = (Point*)malloc(sizeof(Point));
  cout << pp->get_x() << '\n';
  cout << pp->get_y() << '\n';
  free(pp);

  Point* pp1 = new Point(2, 3);
  cout << pp1->get_x() << '\n';
  cout << pp1->get_y() << '\n';
  delete pp1;

  Point* point_array = new Point[10];
  point_array[0] = Point(42, 42);

  delete[] point_array;

  return 0;
}
