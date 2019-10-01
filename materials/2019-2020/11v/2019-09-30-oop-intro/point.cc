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
    double dx = x - other.x;
    double dy = y - other.y;

    return sqrt(dx * dx + dy * dy);
  }
};

int main() {
  Point first_point(3, 4);
  Point second_point(42, 312);

  cout << "Distance: " << first_point.distance_to(second_point) << '\n';

  return 0;
}
