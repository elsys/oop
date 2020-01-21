#ifndef VEHICLE_HH
#define VEHICLE_HH

#include "walker.hh"

class Vehicle : public Walker {
  double amortisation;

public:
  Vehicle(std::string const& description, double average_speed);

  Walker* clone() const;

  double walk(double distance);
};

#endif
