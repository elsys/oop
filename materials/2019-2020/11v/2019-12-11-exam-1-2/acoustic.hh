#ifndef ACOUSTIC_HH
#define ACOUSTIC_HH

#include "guitar.hh"
#include <string>

class Acoustic : public Guitar {
  double sound_power;

public:
  Acoustic(
      unsigned int id,
      double price,
      std::string brand,
      unsigned int strings,
      unsigned int frets,
      double weight,
      double sound_power);

  double get_sound_power() const;
};

#endif
