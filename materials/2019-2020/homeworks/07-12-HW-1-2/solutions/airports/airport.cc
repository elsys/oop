#include "airport.hh"

Airport::Airport(
    unsigned int max_airplane_count,
    double max_airplane_size,
    bool accepts_military,
    bool accepts_civil,
    double x)
  :
    max_airplane_count(max_airplane_count),
    max_airplane_size(max_airplane_size),
    accepts_military(accepts_military),
    accepts_civil(accepts_civil),
    x(x) {}

double Airport::get_x() const {
  return x;
}

bool Airport::can_fit_airplane(Airplane const& airplane) {
  return airplanes.size() < max_airplane_count &&
    airplane.get_size() <= max_airplane_size &&
    (airplane.is_military() && accepts_military ||
     !airplane.is_military() && accepts_civil);
}

void Airport::land_airplane(Airplane const& airplane) {
  if (!can_fit_airplane(airplane)) {
    throw CannotFitAirplaneError();
  }
  airplanes.push_back(airplane);
}
