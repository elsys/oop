#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

#include "cell.hh"

using namespace std;

Cell::Cell(
  vector<string> type,
  float maintenanceCost,
  float requiredPower
) :
  type(type),
  maintenanceCost(maintenanceCost),
  requiredPower(requiredPower)
{ }

const vector<Cell*> Cell::getNeighbors(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const {
  vector<Cell*> neighbors;

  for(int ix = (int)x - 1; ix <= (int)x + 1; ix++) {
    // Ignore indices that are out of bounds
    if(ix < 0) continue;
    if(ix >= matrix.size()) continue;

    for(int iy = (int)y - 1; iy <= (int)y + 1; iy++) {
      if(iy < 0) continue;
      if(iy >= matrix[ix].size()) continue;
      // Ignore the current cell
      if(ix == x && iy == x) continue;
      // Ignore empty cells
      if(matrix[ix][iy] == NULL) continue;

      neighbors.push_back(matrix[ix][iy]);
    }
  }

  return neighbors;
};

void Cell::setLocation(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) {
  this->matrix = &matrix;
  this->x = x;
  this->y = y;
}

vector<string> Cell::getType() const {
  return type;
}

// Join all type strings together
string Cell::getTypeAsString() const {
  string res = "";
  for(auto it = type.begin(); it != type.end(); it++) {
    res += *it;
  }

  return res;
}

bool Cell::hasType(string searched) const {
  // Find a value in a collection
  // https://en.cppreference.com/w/cpp/algorithm/find
  return std::find(type.begin(), type.end(), searched) != type.end();
}

float Cell::getMaintenanceCost() const {
  return maintenanceCost;
}

float Cell::getRequiredPower() const {
  return requiredPower;
}
