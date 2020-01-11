#include "acoustic.hh"

Acoustic::Acoustic(
    unsigned int id,
    double price,
    std::string brand,
    unsigned int strings,
    unsigned int frets,
    double weight,
    double sound_power)
  :
    Guitar(id, price, brand, strings, frets, weight),
    sound_power(sound_power) {}

double Acoustic::get_sound_power() const {
  return sound_power;
}
