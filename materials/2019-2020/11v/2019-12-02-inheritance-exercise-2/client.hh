#ifndef CLIENT_HH
#define CLIENT_HH

#include "order.hh"
#include <string>
#include <iostream>

class Client {
  std::string name;
  Order* orders;
  unsigned int count;

public:
  Client();
  Client(std::string name, Order* orders, unsigned int count);
  Client(Client const& other);
  Client& operator=(Client const& other);
  ~Client();

  void add_order(Order const& order);

  std::string const& get_name() const;
  Order const* get_orders() const;
  unsigned int get_count() const;
};

std::ostream& operator<<(std::ostream& os, Client const& client);

#endif
