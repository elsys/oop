#include "cpu.hh"

CPU::CPU(double price, unsigned int core_count, double frequency)
  : Component(price), core_count(core_count), frequency(frequency) {}

double CPU::get_own_score() const {
  return core_count * frequency;
}

double CPU::get_total_score() const {
  return get_own_score();
}
