#ifndef RAM_HH
#define RAM_HH

#include "component.hh"

class RAM : public Component {
  double size;
  double frequency;

public:
  RAM();
  RAM(double price, double size, double frequency);

  double get_own_score() const;

  double get_total_score() const;
};

#endif
