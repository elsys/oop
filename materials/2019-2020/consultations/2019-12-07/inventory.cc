#include "inventory.hh"
#include "laptop.hh"
#include "car.hh"

std::vector<Device*> const& Inventory::get_devices() const {
  return devices;
}

bool Inventory::is_sorted_by_performance() const {
  if (devices.empty() || devices.size() == 1) {
    return true;
  }

  for (auto iter = devices.begin(); iter != devices.end() - 1; ++iter) {
    if ((*iter)->is_laptop()) {
      if (((Laptop*)(*iter))->get_performance() >
          ((Laptop*)(*(iter + 1)))->get_performance()) {
        return false;
      }
    } else {
      if (((Car*)(*iter))->get_performance() >
          ((Car*)(*(iter + 1)))->get_performance()) {
        return false;
      }
    }
  }

  return true;
}

void Inventory::add_device(Device const& device) {
  if (device.is_laptop()) {
    devices.push_back(new Laptop((Laptop const&)device));
  } else {
    devices.push_back(new Car((Car const&)device));
  }
}

std::ostream& operator<<(std::ostream& os, Inventory const& inventory) {
  auto devices = inventory.get_devices();
  for (auto iter = devices.begin(); iter != devices.end(); ++iter) {
    if ((*iter)->is_laptop()) {
      os << *((Laptop*)*iter);
    } else {
      os << *((Car*)*iter);
    }
    if (iter + 1 != devices.end()) {
      os << '\n';
    }
  }
  return os;
}
