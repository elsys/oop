#include "square.hh"
#include <iostream>

Square::Square(Point const& upper_left, Point const& bottom_right)
  : Rectangle(upper_left, bottom_right) {}

void Square::draw() const {
  std::cout
    << "Square:\n"
    << "\tUpper left corner: "
    << upper_left
    << '\n'
    << "\tBottom right corner: "
    << bottom_right;
}
