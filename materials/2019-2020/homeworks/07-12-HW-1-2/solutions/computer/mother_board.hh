#ifndef MOTHER_BOARD_HH
#define MOTHER_BOARD_HH

#include "component.hh"
#include "cpu.hh"
#include "ram.hh"

class MotherBoard : public Component {
  CPU cpu;
  RAM rams[4];
  unsigned int ram_count;

public:
  MotherBoard(
      double price,
      CPU cpu,
      RAM rams[4],
      unsigned int ram_count);

  MotherBoard(MotherBoard const& other);

  MotherBoard& operator=(MotherBoard const& other);

  double get_own_score() const;

  double get_total_score() const;

  double get_total_price() const;
};

#endif
