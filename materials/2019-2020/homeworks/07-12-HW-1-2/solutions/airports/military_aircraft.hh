#ifndef MILITARY_AIRCRAFT_HH
#define MILITARY_AIRCRAFT_HH

#include "airplane.hh"
#include <iostream>
#include <string>

class MilitaryAircraft : public Airplane {
  double power;

public:
  MilitaryAircraft(
      unsigned int size,
      unsigned int flight_number,
      std::string model,
      double speed,
      double fuel,
      double consumption_per_kilometer,
      double x,
      double power);

  double get_power() const;
};

std::ostream& operator<<(
    std::ostream& os,
    MilitaryAircraft const& military_aircraft);

#endif
