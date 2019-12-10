#include "mother_board.hh"

MotherBoard::MotherBoard(
    double price,
    CPU cpu,
    RAM rams[4],
    unsigned int ram_count)
  :
    Component(price),
    cpu(cpu),
    ram_count(ram_count) {
  for (int i = 0; i < ram_count; ++i) {
    this->rams[i] = rams[i];
  }
}

MotherBoard::MotherBoard(MotherBoard const& other)
  : Component(other), cpu(other.cpu), ram_count(other.ram_count) {
  for (int i = 0; i < other.ram_count; ++i) {
    rams[i] = other.rams[i];
  }
}

MotherBoard& MotherBoard::operator=(MotherBoard const& other) {
  if (this == &other) {
    return *this;
  }

  (Component)*this = other;
  cpu = other.cpu;
  ram_count = other.ram_count;
  for (int i = 0; i < other.ram_count; ++i) {
    rams[i] = other.rams[i];
  }
}

double MotherBoard::get_own_score() const {
  return 0;
}

double MotherBoard::get_total_score() const {
  double total = get_own_score() + cpu.get_total_score();
  for (int i = 0; i < ram_count; ++i) {
    total += rams[i].get_total_score();
  }
  return total;
}

double MotherBoard::get_total_price() const {
  double total = get_own_price() + cpu.get_total_price();
  for (int i = 0; i < ram_count; ++i) {
    total += rams[i].get_total_price();
  }
  return total;
}
