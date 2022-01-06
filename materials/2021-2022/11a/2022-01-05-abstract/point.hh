#ifndef _POINT_HH_
#define _POINT_HH_
#include <string>
class Point {
  int x;
  int y;

public:
  Point(int x, int y);
  Point();
  void set_x(int x);
  void set_y(int y);
  int get_x() const;
  int get_y() const;

  void print() const;
  std::string to_string() const;
};

#endif