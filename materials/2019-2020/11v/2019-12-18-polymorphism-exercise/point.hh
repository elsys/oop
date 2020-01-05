#ifndef POINT_HH
#define POINT_HH

#include <iostream>

class Point {
  double x;
  double y;

public:
  Point(double x, double y);

  double get_x() const;

  double get_y() const;
};

std::ostream& operator<<(std::ostream& os, Point const& point);

#endif
