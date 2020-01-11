#ifndef MUSICAL_INSTRUMENT_HH
#define MUSICAL_INSTRUMENT_HH

#include <string>

class MusicalInstrument {
  unsigned int id;
  double price;
  std::string brand;

public:
  MusicalInstrument(unsigned int id, double price, std::string brand);

  unsigned int get_id() const;
  double get_price() const;
  std::string const& get_brand() const;
};

#endif
