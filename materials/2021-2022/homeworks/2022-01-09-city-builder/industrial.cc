#include <string>
#include <vector>
#include <iostream>

#include "cell.hh"
#include "industrial.hh"

using namespace std;

Industrial::Industrial(
  vector<string> type,
  float maintenanceCost,
  float requiredPower
) :
  Cell(type, maintenanceCost, requiredPower)
{ }

bool Industrial::canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const {
  return true;
}

LightIndustrial::LightIndustrial() : Industrial({"Light", "Industrial"}, 4, 4) { }

int LightIndustrial::getHappiness() const {
  int happiness = 0;
  vector<Cell*> neighbors = getNeighbors(*matrix, x, y);

  for(auto it = neighbors.begin(); it != neighbors.end(); it++) {
    if((*it)->hasType("Residential")) happiness -= 1;
  }

  return happiness;
}

DenseIndustrial::DenseIndustrial() : Industrial({"Dense", "Industrial"}, 6, 8) { }

int DenseIndustrial::getHappiness() const {
  int happiness = 0;
  vector<Cell*> neighbors = getNeighbors(*matrix, x, y);

  for(auto it = neighbors.begin(); it != neighbors.end(); it++) {
    Cell* cell = *it;
    if(cell->hasType("Residential") || cell->hasType("Leisure"))
      happiness -= 2;
  }

  return happiness;
}
