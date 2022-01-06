#ifndef _RECTANGLE_HH_
#define _RECTANGLE_HH_

#include "point.hh"
#include "shape.hh"
class rectangle : public shape {
  Point ul;
  Point lr;

public:
  rectangle(Point ul, Point lr);
  void print() const;
};

#endif