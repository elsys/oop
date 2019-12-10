#include "military_aircraft.hh"

MilitaryAircraft::MilitaryAircraft(
    unsigned int size,
    unsigned int flight_number,
    std::string model,
    double speed,
    double fuel,
    double consumption_per_kilometer,
    double x,
    double power)
  :
    Airplane(
        size, flight_number, model, true, speed,
        fuel, consumption_per_kilometer, x),
    power(power) {}

double MilitaryAircraft::get_power() const {
  return power;
}

std::ostream& operator<<(
    std::ostream& os,
    MilitaryAircraft const& military_aircraft) {
  return os
    << (Airplane)military_aircraft << '\n'
    << "Power: " << military_aircraft.get_power();
}
