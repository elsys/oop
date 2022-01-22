#include <string>
#include <vector>
#include <iostream>

#include "cell.hh"
#include "leisure.hh"

using namespace std;

Leisure::Leisure(
  vector<string> type,
  float maintenanceCost,
  float requiredPower
) :
  Cell(type, maintenanceCost, requiredPower)
{ }

bool Leisure::canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const {
  return true;
}

Mall::Mall() : Leisure({"Mall", "Leisure"}, 8, 4) { }

int Mall::getHappiness() const {
  int happiness = 0;
  vector<Cell*> neighbors = getNeighbors(*matrix, x, y);

  for(auto it = neighbors.begin(); it != neighbors.end(); it++) {
    if((*it)->hasType("Residential")) happiness += 1;
  }

  return happiness;
}

Park::Park() : Leisure({"Park", "Leisure"}, 4, 2) { }

int Park::getHappiness() const {
  int happiness = 0;
  vector<Cell*> neighbors = getNeighbors(*matrix, x, y);

  for(auto it = neighbors.begin(); it != neighbors.end(); it++) {
    Cell* cell = *it;
    if(cell->hasType("Residential")) {
      if(cell->hasType("Light"))
        happiness += 1;
      else if(cell->hasType("Medium"))
        happiness += 2;
      else if(cell->hasType("Dense"))
        happiness += 3;
    }
  }

  return happiness;
}
