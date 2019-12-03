#ifndef MANAGER_HH
#define MANAGER_HH

#include "employee.hh"

class Manager: public Employee {
  unsigned int level;

public:
  Manager(unsigned long id, std::string name, unsigned int level);

  unsigned int get_level() const;

  void print() const;
};

#endif
