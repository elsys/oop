#ifndef MUSIC_STORE_HH
#define MUSIC_STORE_HH

#include <vector>
#include <exception>
#include "guitar.hh"
#include "acoustic.hh"
#include "electric.hh"

class MusicStore {
  std::vector<Acoustic> acoustics;
  std::vector<Electric> electrics;

  std::vector<Acoustic>::const_iterator find_acoustic(unsigned int id) const;

  std::vector<Electric>::const_iterator find_electric(unsigned int id) const;

public:
  class NoAcousticsError: public std::exception {};
  class NoElectricsError: public std::exception {};
  class MusicalInstrumentAlreadyExistsError: public std::exception {};
  class MusicalInstrumentDoesNotExistError: public std::exception {};

  std::vector<Guitar> get_all_in_price_range(
      double from_price,
      double to_price) const;

  std::vector<Guitar> get_all_twelve_strings() const;

  Acoustic const& get_most_powerful_acoustic() const;

  Electric const& get_most_powerful_electric() const;

  void add_acoustic(Acoustic const& acoustic);

  void add_electric(Electric const& electric);

  void buy(Guitar const& guitar);
};

#endif
