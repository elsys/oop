#ifndef ELECTRIC_HH
#define ELECTRIC_HH

#include "guitar.hh"
#include <string>

class Electric : public Guitar {
  unsigned int pickups_count;
  double pickups_output;

public:
  Electric(
      unsigned int id,
      double price,
      std::string brand,
      unsigned int strings,
      unsigned int frets,
      double weight,
      unsigned int pickups_count,
      double pickups_output);

  unsigned int get_pickups_count() const;
  double get_pickups_output() const;
};

#endif
