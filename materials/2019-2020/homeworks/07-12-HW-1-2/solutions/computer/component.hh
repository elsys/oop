#ifndef COMPONENT_HH
#define COMPONENT_HH

class Component {
  double price;

public:
  Component(double price);

  double get_own_price() const;

  double get_total_price() const;
};

#endif
