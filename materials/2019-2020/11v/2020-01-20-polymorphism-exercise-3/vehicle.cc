#include "vehicle.hh"
#include <algorithm>

Vehicle::Vehicle(std::string const& description, double average_speed)
  : Walker(description, average_speed) {}

Walker* Vehicle::clone() const {
  return new Vehicle(*this);
}

double Vehicle::walk(double distance) {
  amortisation += distance;

  double average_speed = get_average_speed();
  double current_average_speed =
    std::max(average_speed - (int)amortisation / 100, average_speed / 2);

  return distance / current_average_speed;
}
