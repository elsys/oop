#ifndef LAPTOP_HH
#define LAPTOP_HH

#include "device.hh"
#include <string>
#include <iostream>

class Laptop : public Device {
  unsigned int speed;

public:
  Laptop(std::string brand, unsigned int speed);

  unsigned int get_speed() const;

  unsigned int get_performance() const;
};

std::ostream& operator<<(std::ostream& os, Laptop const& laptop);

#endif
