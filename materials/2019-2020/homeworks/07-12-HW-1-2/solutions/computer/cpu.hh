#ifndef CPU_HH
#define CPU_HH

#include "component.hh"

class CPU : public Component {
  unsigned int core_count;
  double frequency;

public:
  CPU(double price, unsigned int core_count, double frequency);

  double get_own_score() const;

  double get_total_score() const;
};

#endif
