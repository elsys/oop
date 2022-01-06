#ifndef _CIRCLE_HH_
#define _CIRCLE_HH_
#include "point.hh"
#include "shape.hh"

class circle : public shape {
  Point center;
  int radius;

public:
  circle(Point center, int radius);

  void print() const;
};

#endif