#include "device.hh"

Device::Device(std::string brand, bool laptop)
  : brand(brand), laptop(laptop) {}

std::string const& Device::get_brand() const {
  return brand;
}

bool Device::is_laptop() const {
  return laptop;
}

std::ostream& operator<<(std::ostream& os, Device const& device) {
  return os << device.get_brand();
}
