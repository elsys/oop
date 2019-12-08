#ifndef CAR_HH
#define CAR_HH

#include "device.hh"
#include <string>
#include <iostream>

class Car : public Device {
  unsigned int power;
  unsigned int engine_volume;

public:
  Car(std::string brand, unsigned int power, unsigned int engine_volume);

  unsigned int get_power() const;

  unsigned int get_engine_volume() const;

  unsigned int get_performance() const;
};

std::ostream& operator<<(std::ostream& os, Car const& car);

#endif
