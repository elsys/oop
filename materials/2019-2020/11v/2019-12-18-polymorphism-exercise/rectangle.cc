#include "rectangle.hh"

Rectangle::Rectangle(
    Point const& upper_left,
    Point const& bottom_right)
  : upper_left(upper_left), bottom_right(bottom_right) {}

void Rectangle::draw() const {
  std::cout
    << "Rectangle:\n"
    << "\tUpper left corner: "
    << upper_left
    << '\n'
    << "\tBottom right corner: "
    << bottom_right;
}

double Rectangle::get_width() const {
  return bottom_right.get_x() - upper_left.get_x();
}

double Rectangle::get_height() const {
  return upper_left.get_y() - bottom_right.get_y();
}

double Rectangle::get_perimeter() const {
  return 2 * get_width() + 2 * get_height();
}

double Rectangle::get_area() const {
  return get_width() * get_height();
}
