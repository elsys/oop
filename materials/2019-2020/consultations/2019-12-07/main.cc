#include <iostream>
#include "laptop.hh"
#include "car.hh"
#include "inventory.hh"

int main() {
  Laptop laptop("Lenovo", 333);
  Car car("Audi", 300, 33);

  Inventory inventory;
  inventory.add_device(laptop);
  inventory.add_device(car);
  std::cout << inventory << '\n';

  return 0;
}
