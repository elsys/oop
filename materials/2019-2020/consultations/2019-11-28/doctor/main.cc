#include "surgeon.hh"
#include <iostream>

int main() {
  Surgeon surgeon("Ivan Dobrev", 10, "plastic");
  Surgeon s2 = surgeon; // Surgeon s2(surgeon);
  s2 = surgeon;

  s2 = s2;

  std::cout << surgeon.get_speciality() << '\n';
  std::cout << s2.get_speciality() << '\n';

  return 0;
}
