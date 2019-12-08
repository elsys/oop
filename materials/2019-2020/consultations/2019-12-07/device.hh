#ifndef DEVICE_HH
#define DEVICE_HH

#include <string>
#include <iostream>

class Device {
  std::string brand;
  bool laptop;

public:
  Device(std::string brand, bool laptop = true);

  std::string const& get_brand() const;

  bool is_laptop() const;
};

std::ostream& operator<<(std::ostream& os, Device const& device);

#endif
