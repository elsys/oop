#include "circle.hh"

#include <iostream>

using namespace std;

circle::circle(Point center, int radius) {
  this->center = center;
  this->radius = radius;
}

void circle::print() const {
  cout << "I am circle with center: " << center.to_string()
       << "and radius: " << radius << endl;
}