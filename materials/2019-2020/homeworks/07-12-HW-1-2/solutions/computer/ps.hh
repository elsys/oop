#ifndef PS_HH
#define PS_HH

#include "component.hh"

class PS : public Component {
  double power;

public:
  PS(double price, double power);

  double get_own_score() const;

  double get_total_score() const;
};

#endif
