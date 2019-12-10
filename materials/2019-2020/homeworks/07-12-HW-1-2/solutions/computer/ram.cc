#include "ram.hh"

RAM::RAM(): Component(0), size(0), frequency(0) {}

RAM::RAM(double price, double size, double frequency)
  : Component(price), size(size), frequency(frequency) {}

double RAM::get_own_score() const {
  return size * frequency;
}

double RAM::get_total_score() const {
  return get_own_score();
}
