#include "airfreighter.hh"

Airfreighter::Airfreighter(
    unsigned int size,
    unsigned int flight_number,
    std::string model,
    double speed,
    double fuel,
    double consumption_per_kilometer,
    double x,
    double max_load,
    double current_load)
  :
    Airplane(
        size, flight_number, model, false, speed,
        fuel, consumption_per_kilometer, x),
    max_load(max_load),
    current_load(current_load) {}

double Airfreighter::get_max_load() const {
  return max_load;
}

double Airfreighter::get_current_load() const {
  return current_load;
}

std::ostream& operator<<(std::ostream& os, Airfreighter const& airfreighter) {
  return os
    << (Airplane)airfreighter << '\n'
    << "Max load: " << airfreighter.get_max_load() << '\n'
    << "Current laod: " << airfreighter.get_current_load();
}
