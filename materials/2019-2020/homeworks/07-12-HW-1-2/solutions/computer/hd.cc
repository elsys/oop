#include "hd.hh"

HD::HD(): Component(0), size(0), speed(0) {}

HD::HD(double price, double size, double speed)
  : Component(price), size(size), speed(speed) {}

double HD::get_own_score() const {
  return size * speed / 1000;
}

double HD::get_total_score() const {
  return get_own_score();
}
