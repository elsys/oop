#include "doctor.hh"

Doctor::Doctor(
    std::string name,
    unsigned int experience)
  : name(name), experience(experience) {}

std::string const& Doctor::get_name() const {
  return name;
}

unsigned int Doctor::get_experience() const {
  return experience;
}
