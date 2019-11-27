#include "employee.hh"
#include <string>
#include <iostream>

Employee::Employee(unsigned long id, std::string name)
  : id(id), name(name) {}

unsigned long Employee::get_id() const {
  return id;
}

std::string Employee::get_name() const {
  return name;
}

void Employee::print() const {
  std::cout << get_id() << ": " << get_name();
}
