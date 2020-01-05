#ifndef DRAWING_HH
#define DRAWING_HH

#include "shape.hh"
#include "rectangle.hh"
#include <vector>

class Drawing {
  std::vector<Shape const*> shapes;

public:
  void add_shape(Shape const* shape);

  void draw() const;
};

#endif
