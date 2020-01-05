#include "employee.hh"
#include "manager.hh"
#include <iostream>
#include <vector>

void print_employees(std::vector<Employee*> const& employees) {
  for (auto it = employees.begin(); it != employees.end(); ++it) {
    (*it)->print();
    std::cout << '\n';
  }
}

int main() {
  Employee employee(123123, "Ivan");
  Manager manager(312312, "Yordan", 1337);

  std::vector<Employee*> employees = { &employee, &manager };
  print_employees(employees);

  return 0;
}
