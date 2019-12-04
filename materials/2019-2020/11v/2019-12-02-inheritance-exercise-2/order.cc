#include "order.hh"

Order::Order()
  : id(0), beverages(nullptr), count(0) {}

Order::Order(unsigned int id, Beverage* beverages, unsigned int count)
  : id(id), beverages(new Beverage[count]), count(count) {
  for (int i = 0; i < count; ++i) {
    this->beverages[i] = beverages[i];
  }
}

Order::Order(Order const& other)
  : id(other.id), beverages(new Beverage[other.count]), count(other.count) {
  for (int i = 0; i < other.count; ++i) {
    beverages[i] = other.beverages[i];
  }
}

Order& Order::operator=(Order const& other) {
  if (this == &other) {
    return *this;
  }

  id = other.id;
  delete[] beverages;
  beverages = new Beverage[other.count];
  for (int i = 0; i < other.count; ++i) {
    beverages[i] = other.beverages[i];
  }
  count = other.count;

  return *this;
}

Order::~Order() {
  delete[] beverages;
}

void Order::add_beverage(Beverage const& beverage) {
  Beverage* new_beverages = new Beverage[count + 1];
  for (int i = 0; i < count; ++i) {
    new_beverages[i] = beverages[i];
  }
  new_beverages[count] = beverage;

  delete[] beverages;
  beverages = new_beverages;
  count += 1;
}

unsigned int Order::get_id() const {
  return id;
}

Beverage const* Order::get_beverages() const {
  return beverages;
}

unsigned int Order::get_count() const {
  return count;
}

std::ostream& operator<<(std::ostream& os, Order const& order) {
  os << "Order " << order.get_id() << ':';
  if (order.get_count() == 0) {
    return os << " empty";
  }
  os << '\n';

  for (int i = 0; i < order.get_count() - 1; ++i) {
    os << '\t' << order.get_beverages()[i] << '\n';
  }
  return os << '\t' << order.get_beverages()[order.get_count() - 1];
}
