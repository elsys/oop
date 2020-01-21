#include "class_template.hh"
#include <iostream>

int main() {
  Foo<int> foo;
  Foo<double> bar;

  std::cout << foo.sum(1, 2) << '\n';
  std::cout << bar.sum(1, 2) << '\n';

  return 0;
}
