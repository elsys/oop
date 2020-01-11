#include "musical_instrument.hh"

MusicalInstrument::MusicalInstrument(
    unsigned int id,
    double price,
    std::string brand)
  :
    id(id),
    price(price),
    brand(brand) {}

unsigned int MusicalInstrument::get_id() const {
  return id;
}

double MusicalInstrument::get_price() const {
  return price;
}

std::string const& MusicalInstrument::get_brand() const {
  return brand;
}
