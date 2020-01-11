#ifndef GUITAR_HH
#define GUITAR_HH

#include "musical_instrument.hh"
#include <string>

class Guitar : public MusicalInstrument {
  unsigned int strings;
  unsigned int frets;
  double weight;

public:
  Guitar(
      unsigned int id,
      double price,
      std::string brand,
      unsigned int strings,
      unsigned int frets,
      double weight);

  unsigned int get_strings() const;
  unsigned int get_frets() const;
  double get_weight() const;
};

#endif
