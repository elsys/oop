#ifndef AIRFREIGHTER_HH
#define AIRFREIGHTER_HH

#include "airplane.hh"
#include <iostream>
#include <string>

class Airfreighter : public Airplane {
  double max_load;
  double current_load;

public:
  Airfreighter(
      unsigned int size,
      unsigned int flight_number,
      std::string model,
      double speed,
      double fuel,
      double consumption_per_kilometer,
      double x,
      double max_load,
      double current_load = 0);

  double get_max_load() const;

  double get_current_load() const;
};

std::ostream& operator<<(std::ostream& os, Airfreighter const& airfreighter);

#endif
