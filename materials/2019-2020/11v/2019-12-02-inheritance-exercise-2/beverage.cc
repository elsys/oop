#include "beverage.hh"

Beverage::Beverage()
  : volume(0), price(0) {}

Beverage::Beverage(std::string name, double volume, double price)
  : name(name), volume(volume), price(price) {}

std::string const& Beverage::get_name() const {
  return name;
}

double Beverage::get_volume() const {
  return volume;
}

double Beverage::get_price() const {
  return price;
}

std::ostream& operator<<(std::ostream& os, Beverage const& beverage) {
  return os
    << beverage.get_name() << ", "
    << beverage.get_volume() << "mL, "
    << beverage.get_price() << "lv";
}
