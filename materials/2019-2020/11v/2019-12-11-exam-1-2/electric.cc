#include "electric.hh"

Electric::Electric(
    unsigned int id,
    double price,
    std::string brand,
    unsigned int strings,
    unsigned int frets,
    double weight,
    unsigned int pickups_count,
    double pickups_output)
  :
    Guitar(id, price, brand, strings, frets, weight),
    pickups_count(pickups_count),
    pickups_output(pickups_output) {}

unsigned int Electric::get_pickups_count() const {
  return pickups_count;
}

double Electric::get_pickups_output() const {
  return pickups_output;
}
