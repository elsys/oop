#ifndef _SQARE_HH_
#define _SQARE_HH_

#include "point.hh"
#include "shape.hh"
class sqare : public shape {
  Point ul;
  int lenght;

public:
  sqare(Point ul, int length);

  void print() const;
};

#endif