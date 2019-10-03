#include <iostream>
#include <cmath>

using namespace std;

class Point {
  double x;
  double y;

public:
  Point(double x, double y) {
    this->x = x;
    this->y = y;
  }

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
  Point first_point(5, 4);
  Point second_point(42, 123);

  cout << "Distance: " << first_point.distance_to(second_point) << '\n';

  Point third_point = first_point.add(second_point);
  third_point.print();

  return 0;
}
