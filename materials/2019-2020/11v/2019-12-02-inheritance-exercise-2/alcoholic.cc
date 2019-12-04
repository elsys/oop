#include "alcoholic.hh"

Alcoholic::Alcoholic(
    std::string name,
    double volume,
    double price,
    double percentage)
  : Beverage(name, volume, price),
    percentage(percentage) {}

double Alcoholic::get_percentage() const {
  return percentage;
}
