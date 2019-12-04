#ifndef BEVERAGE_HH
#define BEVERAGE_HH

#include <string>
#include <iostream>

class Beverage {
  std::string name;
  double volume;
  double price;

public:
  Beverage();
  Beverage(std::string name, double volume, double price);

  std::string const& get_name() const;
  double get_volume() const;
  double get_price() const;
};

std::ostream& operator<<(std::ostream& os, Beverage const& beverage);

#endif
