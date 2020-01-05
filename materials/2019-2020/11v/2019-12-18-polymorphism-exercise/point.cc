#include "point.hh"

Point::Point(double x, double y): x(x), y(y) {}

double Point::get_x() const {
  return x;
}

double Point::get_y() const {
  return y;
}

std::ostream& operator<<(std::ostream& os, Point const& point) {
  return os
    << '('
    << point.get_x()
    << ", "
    << point.get_y()
    << ')';
}
