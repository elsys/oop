#ifndef NON_ALCOHOLIC_HH
#define NON_ALCOHOLIC_HH

#include "beverage.hh"
#include <string>

class NonAlcoholic : public Beverage {
public:
  NonAlcoholic(std::string name, double volume, double price);
};

#endif
