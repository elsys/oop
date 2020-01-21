#include "walker.hh"

Walker::Walker(std::string const& description, double average_speed)
  : description(description), average_speed(average_speed) {}

double Walker::get_average_speed() const {
  return average_speed;
}

Walker* Walker::clone() const {
  return new Walker(*this);
}

double Walker::walk(double distance) {
  return distance / get_average_speed();
}
