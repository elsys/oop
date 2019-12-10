#ifndef HD_HH
#define HD_HH

#include "component.hh"

class HD : public Component {
  double size;
  double speed;

public:
  HD();
  HD(double price, double size, double speed);

  double get_own_score() const;

  double get_total_score() const;
};

#endif
