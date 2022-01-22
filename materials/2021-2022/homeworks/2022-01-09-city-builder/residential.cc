#include <string>
#include <vector>
#include <iostream>

#include "cell.hh"
#include "residential.hh"

using namespace std;

Residential::Residential(
  vector<string> type,
  float maintenanceCost,
  float requiredPower,
  int residentCapacity
) :
  Cell(type, maintenanceCost, requiredPower),
  residentCapacity(residentCapacity)
{ }

int Residential::getResidentCapacity() const {
  return residentCapacity;
}

bool Residential::canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const {
  vector<Cell*> neighbors = getNeighbors(matrix, x, y);

  for(auto it = neighbors.begin(); it != neighbors.end(); it++) {
    if((*it)->hasType("Road")) return true;
  }

  return false;
}

LightResidential::LightResidential() : Residential({"Light", "Residential"}, 2, 2, 5) { }

MediumResidential::MediumResidential() : Residential({"Medium", "Residential"}, 4, 4, 20) { }

DenseResidential::DenseResidential() : Residential({"Dense", "Residential"}, 6, 8, 50) { }

bool DenseResidential::canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const {
  vector<Cell*> neighbors = getNeighbors(matrix, x, y);

  bool hasRoad = false, hasLeisure = false;
  for(auto it = neighbors.begin(); it != neighbors.end(); it++) {
    if((*it)->hasType("Road")) hasRoad = true;
    if((*it)->hasType("Leisure")) hasLeisure = true;
    if(hasRoad && hasLeisure) return true;
  }

  return false;
}
