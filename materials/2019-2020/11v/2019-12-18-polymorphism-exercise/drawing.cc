#include "drawing.hh"
#include <iostream>

Drawing::Drawing() {}

Drawing::Drawing(Drawing const& other) {
  for (auto iter = other.shapes.begin(); iter != other.shapes.end(); ++iter) {
    shapes.push_back((*iter)->clone());
  }
}

Drawing& Drawing::operator=(Drawing const& other) {
  if (this == &other) {
    return *this;
  }

  for (auto iter = shapes.begin(); iter != shapes.end(); ++iter) {
    delete *iter;
  }
  shapes.clear();

  for (auto iter = other.shapes.begin(); iter != other.shapes.end(); ++iter) {
    shapes.push_back((*iter)->clone());
  }
}

Drawing::~Drawing() {
  for (auto iter = shapes.begin(); iter != shapes.end(); ++iter) {
    delete *iter;
  }
}

void Drawing::add_shape(Shape const* shape) {
  shapes.push_back(shape->clone());
}

void Drawing::draw() const {
  for (auto iter = shapes.begin(); iter != shapes.end(); ++iter) {
    (*iter)->draw();
    std::cout << '\n';
  }
}
