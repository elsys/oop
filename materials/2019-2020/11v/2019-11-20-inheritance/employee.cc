#include <string>
#include <iostream>

class Employee {
  unsigned long id;
  std::string name;

public:
  Employee(unsigned long id, std::string name)
    : id(id), name(name) {}

  unsigned long get_id() const {
    return id;
  }

  std::string get_name() const {
    return name;
  }

  void print() const {
    std::cout << get_id() << ": " << get_name();
  }
};
