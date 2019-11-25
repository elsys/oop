#include <iostream>
#include "employee.cc"

class Manager: public Employee {
  unsigned int level;

public:
  Manager(unsigned long id, std::string name, unsigned int level)
    : Employee(id, name), level(level) {}

  unsigned int get_level() const {
    return level;
  }

  void print() const {
    Employee::print();
    std::cout << ", " << get_level();
  }
};
