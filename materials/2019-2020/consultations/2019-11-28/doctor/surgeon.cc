#include "surgeon.hh"
#include <cstring>

Surgeon::Surgeon(
    std::string name,
    unsigned int experience,
    char const* speciality)
  : Doctor(name, experience),
    speciality(new char[strlen(speciality) + 1]) {
  strcpy(this->speciality, speciality);
}

Surgeon::Surgeon(Surgeon const& other)
  : Doctor(other),
    speciality(new char[strlen(other.speciality) + 1]) {
  strcpy(speciality, other.speciality);
}

Surgeon& Surgeon::operator=(Surgeon const& other) {
  if (this == &other) {
    return *this;
  }

  (Doctor)*this = (Doctor const&)other;

  delete[] speciality;
  speciality = new char[strlen(other.speciality) + 1];
  strcpy(speciality, other.speciality);

  return *this;
}

Surgeon::~Surgeon() {
  delete[] speciality;
}

char const* Surgeon::get_speciality() const {
  return speciality;
}
