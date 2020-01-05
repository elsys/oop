#ifndef EMPLOYEE_HH
#define EMPLOYEE_HH

#include <string>

class Employee {
  unsigned long id;
  std::string name;

public:
  Employee(unsigned long id, std::string name);

  unsigned long get_id() const;

  std::string get_name() const;

  virtual void print() const;
};

#endif
