#ifndef DOCTOR_HH
#define DOCTOR_HH

#include <string>

class Doctor {
  std::string name;
  unsigned int experience;

public:
  Doctor(std::string name, unsigned int experience);

  std::string const& get_name() const;
  unsigned int get_experience() const;
};

#endif
