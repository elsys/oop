#include "guitar.hh"

Guitar::Guitar(
    unsigned int id,
    double price,
    std::string brand,
    unsigned int strings,
    unsigned int frets,
    double weight)
  :
    MusicalInstrument(id, price, brand),
    strings(strings),
    frets(frets),
    weight(weight) {}

unsigned int Guitar::get_strings() const {
  return strings;
}

unsigned int Guitar::get_frets() const {
  return frets;
}

double Guitar::get_weight() const {
  return weight;
}
