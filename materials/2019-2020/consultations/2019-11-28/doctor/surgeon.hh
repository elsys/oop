#ifndef SURGEON_HH
#define SURGEON_HH

#include "doctor.hh"

class Surgeon : public Doctor {
  char* speciality;

public:
  Surgeon(
      std::string name,
      unsigned int experience,
      char const* speciality);

  Surgeon(Surgeon const& other);

  Surgeon& operator=(Surgeon const& other);

  ~Surgeon();

  char const* get_speciality() const;
};

#endif
