#ifndef POSITION_HH
#define POSITION_HH

#include <math.h>

class Position {
public:
  int x;
  int y;
  int z;

  Position();
  Position(int x, int y, int z);

  float distanceTo(Position other);
};

#endif
