#include "sqare.hh"

#include <iostream>
using namespace std;

sqare::sqare(Point ul, int length) {
  this->ul = ul;
  this->lenght = lenght;
}

void sqare::print() const {
    cout << "I am sqare at: " << ul.to_string() << " with lenght: " << lenght << endl;
}