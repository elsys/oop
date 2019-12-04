#include "wine.hh"
#include "beer.hh"
#include "order.hh"
#include "client.hh"
#include <iostream>

int main() {
  Wine red("Melnik", 750, 23, 12);
  Wine rose("French", 250, 19, 9, Wine::rose);
  Beer amstel("Amstel", 500, 5, 6.3);
  Beverage beverages[] = { red, rose, amstel };

  Order order(1, beverages, 3);
  Order orders[] = { order };

  Client client("Ivan", orders, 1);

  std::cout << client << '\n';

  return 0;
}
