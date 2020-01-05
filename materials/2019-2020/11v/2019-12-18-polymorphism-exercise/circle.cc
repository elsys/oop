#include "circle.hh"
#include <iostream>
#include <cmath>

Circle::Circle(Point const& center, double radius)
  : center(center), radius(radius) {}

void Circle::draw() const {
  std::cout
    << "Circle:\n"
    << "\tCenter: "
    << center
    << '\n'
    << "\tRadius: "
    << radius;
}

double Circle::get_perimeter() const {
  return 2 * M_PI * radius;
}

double Circle::get_area() const {
  return M_PI * radius * radius;
}
