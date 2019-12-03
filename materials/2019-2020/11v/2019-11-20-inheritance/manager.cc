#include "manager.hh"
#include <iostream>

Manager::Manager(unsigned long id, std::string name, unsigned int level)
  : Employee(id, name), level(level) {}

unsigned int Manager::get_level() const {
  return level;
}

void Manager::print() const {
  Employee::print();
  std::cout << ", " << get_level();
}
