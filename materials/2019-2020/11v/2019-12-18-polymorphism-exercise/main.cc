#include "circle.hh"
#include "rectangle.hh"
#include "square.hh"
#include "drawing.hh"
#include <iostream>

int main() {
  Circle circle(Point(0, 3), 3);
  Rectangle rectangle(Point(4, 3), Point(6, 0));
  Square square(Point(3, 3), Point(6, 0));

  Drawing drawing;
  drawing.add_shape(&circle);
  drawing.add_shape(&rectangle);
  drawing.add_shape(&square);

  drawing.draw();

  return 0;
}
