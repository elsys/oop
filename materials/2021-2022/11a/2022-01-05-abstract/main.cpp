#include "circle.hh"
#include "rectangle.hh"
#include "shape.hh"
#include "sqare.hh"
#include "point.hh"

#include <list>

using namespace std;

void print(list<shape *> l) {
  for (auto it = l.begin(); it != l.end(); it++) {
    (*it)->print();
  }
}

int main() {
  Point p(1, 2);
  sqare s(p, 2);
  Point center(2, 2);
  Point ul(2, 3);
  Point lr(5, 6);
  circle c(center, 2);
  rectangle r(ul, lr);

  list<shape *> drawing;
  drawing.push_back(&s);
  drawing.push_back(&c);
  drawing.push_back(&r);
  print(drawing);
}