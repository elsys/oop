#ifndef RECTANGLE_HH
#define RECTANGLE_HH

#include "shape.hh"
#include "point.hh"

class Rectangle : public Shape {
protected:
  Point const upper_left;
  Point const bottom_right;

public:
  Rectangle(Point const& upper_left, Point const& bottom_right);

  void draw() const;

  double get_width() const;

  double get_height() const;

  double get_perimeter() const;

  double get_area() const;
};

#endif
