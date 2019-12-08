#include "car.hh"

Car::Car(std::string brand, unsigned int power, unsigned int engine_volume)
  : Device(brand, false), power(power), engine_volume(engine_volume) {}

unsigned int Car::get_power() const {
  return power;
}

unsigned int Car::get_engine_volume() const {
  return engine_volume;
}

unsigned int Car::get_performance() const {
  return get_power();
}

std::ostream& operator<<(std::ostream& os, Car const& car) {
  return os
    << "Car:\n"
    << (Device)car
    << "\nPower: "
    << car.get_power()
    << "\nEngine volume: "
    << car.get_engine_volume()
    << "\nPerformance: "
    << car.get_performance();
}
