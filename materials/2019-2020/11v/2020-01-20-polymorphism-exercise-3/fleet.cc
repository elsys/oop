#include "fleet.hh"

Fleet::Fleet() {}

Fleet::Fleet(Fleet const& other) {
  for (auto iter = other.walkers.begin(); iter != other.walkers.end(); ++iter) {
    add_walker(*iter);
  }
}

Fleet& Fleet::operator=(Fleet const& other) {
  if (this == &other) {
    return *this;
  }

  for (auto iter = walkers.begin(); iter != walkers.end(); ++iter) {
    delete *iter;
  }

  for (auto iter = other.walkers.begin(); iter != other.walkers.end(); ++iter) {
    add_walker(*iter);
  }

  return *this;
}

Fleet::~Fleet() {
  for (auto iter = walkers.begin(); iter != walkers.end(); ++iter) {
    delete *iter;
  }
}

void Fleet::add_walker(Walker const* walker) {
  walkers.push_back(walker->clone());
}

double Fleet::walk_all(double distance) {
  double time = 0;
  for (auto iter = walkers.begin(); iter != walkers.end(); ++iter) {
    time += (*iter)->walk(distance);
  }
  return distance / (time / walkers.size());
}
