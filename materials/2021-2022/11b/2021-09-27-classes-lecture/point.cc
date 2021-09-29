#include <iostream>
using namespace std;

#include "point.hh"

Point::Point() {
  x = 0.0;
  y = 0.0;
  z = 0.0;
}

Point::Point(float x, float y, float z) {
  this->x = x;
  this->y = y;
  this->z = z;
}

void Point::print() {
  cout << x << " " << y << " " << z << endl;
}

void Point::foo() {
  std::cout << "TEST in class" << std::endl;
}
