#include "rectangle.hh"
#include <iostream>

using namespace std;

rectangle::rectangle(Point ul, Point lr) {
  this->ul = ul;
  this->lr = lr;
}

void rectangle::print() const {
  cout << "I am rectangle at: " << ul.to_string() << " and " << lr.to_string()
       << endl;
}