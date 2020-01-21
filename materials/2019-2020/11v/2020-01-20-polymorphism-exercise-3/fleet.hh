#ifndef FLEET_HH
#define FLEET_HH

#include <vector>
#include "walker.hh"

class Fleet {
  std::vector<Walker*> walkers;

public:
  Fleet();

  Fleet(Fleet const& other);
  
  Fleet& operator=(Fleet const& other);

  ~Fleet();

  void add_walker(Walker const* walker);

  double walk_all(double distance);
};

#endif
