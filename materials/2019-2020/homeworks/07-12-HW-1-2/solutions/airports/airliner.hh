#ifndef AIRLINER_HH
#define AIRLINER_HH

#include "airplane.hh"
#include <iostream>
#include <string>

class Airliner : public Airplane {
  unsigned int passengers;
  unsigned int seats;
  unsigned int exits;

public:
  Airliner(
      unsigned int size,
      unsigned int flight_number,
      std::string model,
      double speed,
      double fuel,
      double consumption_per_kilometer,
      double x,
      unsigned int passengers,
      unsigned int seats,
      unsigned int exits);

  unsigned int get_passengers() const;

  unsigned int get_seats() const;

  unsigned int get_exits() const;
};

std::ostream& operator<<(std::ostream& os, Airliner const& airliner);

#endif
