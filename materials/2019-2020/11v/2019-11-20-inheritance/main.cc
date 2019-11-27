#include "employee.hh"
#include "manager.hh"
#include <iostream>

int main() {
  Employee e(123123, "Ivan");
  Manager m(312312, "Yordan", 1337);

  e.print();
  std::cout << '\n';
  m.print();
  std::cout << '\n';

  Employee* employees[10];
  employees[0] = &e;
  employees[1] = &m;

  Manager* managers[10];
  managers[0] = &m;
  // managers[1] = &e; // error!

  return 0;
}
