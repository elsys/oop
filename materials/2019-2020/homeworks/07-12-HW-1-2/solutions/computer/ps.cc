#include "ps.hh"

PS::PS(double price, double power)
  : Component(price), power(power) {}

double PS::get_own_score() const {
  return power / 100;
}

double PS::get_total_score() const {
  return get_own_score();
}
