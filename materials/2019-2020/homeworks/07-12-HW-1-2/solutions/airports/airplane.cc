#include "airplane.hh"
#include <cmath>

Airplane::Airplane(
    unsigned int size,
    unsigned int flight_number,
    std::string model,
    bool military,
    double speed,
    double fuel,
    double consumption_per_kilometer,
    double x)
  :
    size(size),
    flight_number(flight_number),
    model(model),
    military(military),
    speed(speed),
    fuel(fuel),
    consumption_per_kilometer(consumption_per_kilometer),
    x(x) {}

unsigned int Airplane::get_size() const {
  return size;
}

unsigned int Airplane::get_flight_number() const {
  return flight_number;
}

std::string const& Airplane::get_model() const {
  return model;
}

bool Airplane::is_military() const {
  return military;
}

double Airplane::get_speed() const {
  return speed;
}

double Airplane::get_fuel() const {
  return fuel;
}

double Airplane::get_consumption_per_kilometer() const {
  return consumption_per_kilometer;
}

double Airplane::get_x() const {
  return x;
}

double Airplane::distance_to_airport(Airport const& airport) const {
  return std::fabs(get_x() - airport.get_x());
}

bool Airplane::can_reach(Airport const& airport) const {
  return get_fuel() >=
    get_consumption_per_kilometer() * distance_to_airport(airport);
}

void Airplane::land_in_nearest_airport(std::list<Airport>& airports) {
  std::list<Airport>::iterator first_reachable = airports.end();
  for (std::list<Airport>::iterator iter = airports.begin(); iter != airports.end(); ++iter) {
    if (can_reach(*iter)) {
      first_reachable = iter;
      break;
    }
  }

  if (first_reachable == airports.end()) {
    throw NoReachableAirportError();
  }

  auto nearest = first_reachable;
  for (auto iter = ++first_reachable; iter != airports.end(); ++iter) {
    if (can_reach(*iter) &&
        iter->can_fit_airplane(*this) &&
        distance_to_airport(*iter) < distance_to_airport(*nearest)) {
      nearest = iter;
    }
  }

  nearest->land_airplane(*this);
  x = nearest->get_x();
}

std::ostream& operator<<(std::ostream& os, Airplane const& airplane) {
  return os
    << "Size: " << airplane.get_size() << '\n'
    << "Flight number: " << airplane.get_flight_number() << '\n'
    << "Model: " << airplane.get_model() << '\n'
    << "Military: " << std::boolalpha << airplane.is_military() << '\n'
    << "Speed: " << airplane.get_speed() << '\n'
    << "Fuel: " << airplane.get_fuel() << '\n'
    << "Consumption per kilometer: "
    << airplane.get_consumption_per_kilometer() << '\n'
    << "Position: " << airplane.get_x();
}
