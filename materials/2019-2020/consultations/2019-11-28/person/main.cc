#include <iostream>
#include "person.hh"
#include "student.hh"

int main() {
  Person person("Ivan", "Dobrev", 23);
  std::cout << person << '\n';

  Student student(
      "Yordan", "Ivanov", 21, "Computer Science", 6);
  std::cout << student << '\n';

  return 0;
}
