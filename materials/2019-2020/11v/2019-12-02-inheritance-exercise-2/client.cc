#include "client.hh"

Client::Client()
  : orders(nullptr), count(0) {}

Client::Client(std::string name, Order* orders, unsigned int count)
  : name(name), orders(new Order[count]), count(count) {
  for (int i = 0; i < count; ++i) {
    this->orders[i] = orders[i];
  }
}

Client::Client(Client const& other)
  : name(other.name), orders(new Order[other.count]), count(other.count) {
  for (int i = 0; i < other.count; ++i) {
    orders[i] = other.orders[i];
  }
}

Client& Client::operator=(Client const& other) {
  if (this == &other) {
    return *this;
  }

  name = other.name;
  delete[] orders;
  orders = new Order[other.count];
  for (int i = 0; i < other.count; ++i) {
    orders[i] = other.orders[i];
  }
  count = other.count;

  return *this;
}

Client::~Client() {
  delete[] orders;
}

void Client::add_order(Order const& order) {
  Order* new_orders = new Order[count + 1];
  for (int i = 0; i < count; ++i) {
    new_orders[i] = orders[i];
  }
  new_orders[count] = order;

  delete[] orders;
  orders = new_orders;
  count += 1;
}

std::string const& Client::get_name() const {
  return name;
}

Order const* Client::get_orders() const {
  return orders;
}

unsigned int Client::get_count() const {
  return count;
}

std::ostream& operator<<(std::ostream& os, Client const& client) {
  os << client.get_name() << "\'s orders:";
  if (client.get_count() == 0) {
    return os << " no orders";
  }
  os << '\n';

  for (int i = 0; i < client.get_count() - 1; ++i) {
    os << '\t' << client.get_orders()[i] << '\n';
  }
  return os << '\t' << client.get_orders()[client.get_count() - 1];
}
