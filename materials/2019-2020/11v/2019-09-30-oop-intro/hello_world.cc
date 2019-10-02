#include <iostream>

int main() {
  char name[100];
  int n;
  std::cin >> name >> n;

  std::cout
    << "Hello, "
    << name
    << "! My favourite number is: "
    << n
    << ".\n";

  return 0;
}
