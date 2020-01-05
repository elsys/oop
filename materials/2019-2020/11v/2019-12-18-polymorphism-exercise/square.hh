#ifndef SQUARE_HH
#define SQUARE_HH

#include "rectangle.hh"
#include "point.hh"

class Square : public Rectangle {
public:
  Square(Point const& upper_left, Point const& bottom_right);

  void draw() const;
};

#endif
