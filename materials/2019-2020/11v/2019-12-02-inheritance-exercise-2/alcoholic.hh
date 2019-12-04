#ifndef ALCOHOLIC_HH
#define ALCOHOLIC_HH

#include "beverage.hh"
#include <string>

class Alcoholic : public Beverage {
  double percentage;

public:
  Alcoholic(std::string name, double volume, double price, double percentage);

  double get_percentage() const;
};

#endif
