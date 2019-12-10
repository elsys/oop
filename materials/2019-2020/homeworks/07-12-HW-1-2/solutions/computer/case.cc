#include "case.hh"

Case::Case(
    double price,
    MotherBoard mother_board,
    PS ps,
    HD hds[6],
    unsigned int hd_count)
  :
    Component(price),
    mother_board(mother_board),
    ps(ps),
    hd_count(hd_count) {
  for (int i = 0; i < hd_count; ++i) {
    this->hds[i] = hds[i];
  }
}

Case::Case(Case const& other)
  :
    Component(other),
    mother_board(other.mother_board),
    ps(ps),
    hd_count(other.hd_count) {
  for (int i = 0; i < other.hd_count; ++i) {
    hds[i] = other.hds[i];
  }
}

Case& Case::operator=(Case const& other) {
  if (this == &other) {
    return *this;
  }

  (Component)*this = other;
  mother_board = other.mother_board;
  ps = other.ps;
  hd_count = other.hd_count;
  for (int i = 0; i < other.hd_count; ++i) {
    hds[i] = other.hds[i];
  }
}

double Case::get_own_score() const {
  return 0;
}

double Case::get_total_score() const {
  double total = get_own_score() +
    mother_board.get_total_score() +
    ps.get_total_score();
  for (int i = 0; i < hd_count; ++i) {
    total += hds[i].get_total_score();
  }
  return total;
}

double Case::get_total_price() const {
  double total = get_own_price() +
    mother_board.get_total_price() +
    ps.get_total_price();
  for (int i = 0; i < hd_count; ++i) {
    total += hds[i].get_total_price();
  }
  return total;
}
