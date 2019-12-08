#ifndef INVENTORY_HH
#define INVENTORY_HH

#include <vector>
#include "device.hh"

class Inventory {
  std::vector<Device*> devices;

public:
  std::vector<Device*> const& get_devices() const;

  bool is_sorted_by_performance() const;

  void add_device(Device const& device);
};

std::ostream& operator<<(std::ostream& os, Inventory const& inventory);

#endif
