#include "./position.hh"

Position::Position() : x(0), y(0), z(0) {};
Position::Position(int x, int y, int z) : x(x), y(y), z(z) {};

float Position::distanceTo(Position other) {
  int _x = x - other.x;
  int _y = y - other.y;

  return sqrt(_x * _x + _y * _y);
}
