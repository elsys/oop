#include "laptop.hh"

Laptop::Laptop(std::string brand, unsigned int speed)
  : Device(brand), speed(speed) {}

unsigned int Laptop::get_speed() const {
  return speed;
}

unsigned int Laptop::get_performance() const {
  return get_speed();
}

std::ostream& operator<<(std::ostream& os, Laptop const& laptop) {
  return os
    << "Laptop:\n"
    << (Device)laptop
    << "\nSpeed: "
    << laptop.get_speed()
    << "\nPerformance: "
    << laptop.get_performance();
}
