#include "component.hh"

Component::Component(double price): price(price) {}

double Component::get_own_price() const {
  return price;
}

double Component::get_total_price() const {
  return get_own_price();
}
