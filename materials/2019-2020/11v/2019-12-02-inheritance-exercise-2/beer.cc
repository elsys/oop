#include "beer.hh"

Beer::Beer(
    std::string name,
    double volume,
    double price,
    double percentage,
    bool dark)
  : Alcoholic(name, volume, price, percentage),
    dark(dark) {}

bool Beer::is_dark() const {
  return dark;
}
