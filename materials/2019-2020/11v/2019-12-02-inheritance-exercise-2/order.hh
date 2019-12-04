#ifndef ORDER_HH
#define ORDER_HH

#include "beverage.hh"
#include <iostream>

class Order {
  unsigned int id;
  Beverage* beverages;
  unsigned int count;

public:
  Order();
  Order(unsigned int id, Beverage* beverages, unsigned int count);
  Order(Order const& other);
  Order& operator=(Order const& other);
  ~Order();

  void add_beverage(Beverage const& beverage);

  unsigned int get_id() const;
  Beverage const* get_beverages() const;
  unsigned int get_count() const;
};

std::ostream& operator<<(std::ostream& os, Order const& order);

#endif
