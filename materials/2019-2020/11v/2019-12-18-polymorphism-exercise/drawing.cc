#include "drawing.hh"
#include <iostream>

void Drawing::add_shape(Shape const* shape) {
  shapes.push_back(shape);
}

void Drawing::draw() const {
  for (auto iter = shapes.begin(); iter != shapes.end(); ++iter) {
    (*iter)->draw();
    std::cout << '\n';
  }
}
