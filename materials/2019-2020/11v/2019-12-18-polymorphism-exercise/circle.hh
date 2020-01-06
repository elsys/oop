#ifndef CIRCLE_HH
#define CIRCLE_HH

#include "shape.hh"
#include "point.hh"

class Circle : public Shape {
  Point const center;
  double const radius;

public:
  Circle(Point const& center, double radius);

  Shape* clone() const;

  void draw() const;

  double get_perimeter() const;

  double get_area() const;
};

#endif
