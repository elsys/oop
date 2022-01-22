#include <iostream>
#include <iomanip>
#include <stdexcept>

#include "city.hh"
#include "cell.hh"
#include "leisure.hh"
#include "industrial.hh"
#include "road.hh"
#include "residential.hh"

using namespace std;

City::City(unsigned int width, unsigned int height) {
  matrix.resize(width);

  for(int x = 0; x < width; x++) {
    matrix[x].resize(height);

    for(int y = 0; y < height; y++) {
      // Ensure all pointers point to NULL to let us know they're empty
      matrix[x][y] = NULL;
    }
  }

  cout << "City: Created city with size (" << width << ", " << height << ")" << endl;
}

int City::width() const {
  return matrix.size();
}

int City::height() const {
  return matrix[0].size();
}

vector<Cell*> City::getAllBuildings() const {
  vector<Cell*> all;

  for(int y = 0; y < height(); y++) {
    for(int x = 0; x < width(); x++) {
      Cell* cell = matrix[x][y];
      if(cell == NULL) continue;

      // Push all non-empty cells
      all.push_back(cell);
    }
  }

  return all;
}

// All the get* methods have the same structure:
// - get all non-empty cells
// - iterate
// - if needed cast to a child class
// - get the value and add it to the total
// - return the total
float City::getMaintenanceCost() const {
  int maintenanceCost = 0;
  vector<Cell*> buildings = getAllBuildings();

  for(auto it = buildings.begin(); it != buildings.end(); it++) {
    maintenanceCost += (*it)->getMaintenanceCost();
  }

  return maintenanceCost;
}

float City::getRoadLength() const {
  int roadLength = 0;
  vector<Cell*> buildings = getAllBuildings();

  for(auto it = buildings.begin(); it != buildings.end(); it++) {
    if((*it)->hasType("Road"))
      roadLength += ((Road*)(*it))->getRoadLength();
  }

  return roadLength;
}

float City::getResidentCapacity() const {
  int residentCapacity = 0;
  vector<Cell*> buildings = getAllBuildings();

  for(auto it = buildings.begin(); it != buildings.end(); it++) {
    if((*it)->hasType("Residential"))
      residentCapacity += ((Residential*)(*it))->getResidentCapacity();
  }

  return residentCapacity;
}

float City::getRequiredPower() const {
  int requiredPower = 0;
  vector<Cell*> buildings = getAllBuildings();

  for(auto it = buildings.begin(); it != buildings.end(); it++) {
    requiredPower += (*it)->getRequiredPower();
  }

  return requiredPower;
}

float City::getHappiness() const {
  int happiness = 0;
  vector<Cell*> buildings = getAllBuildings();

  for(auto it = buildings.begin(); it != buildings.end(); it++) {
    // Abtract classes(interfaces) can be used in a better way to help make this casting less stupid
    // This is fine for now
    if((*it)->hasType("Leisure"))
      happiness += ((Leisure*)(*it))->getHappiness();
    if((*it)->hasType("Industrial"))
      happiness += ((Industrial*)(*it))->getHappiness();
  }

  return happiness;
}

void City::build(unsigned int x, unsigned int y, Cell* cell) {
  cout << "City: Try to build " << cell->getTypeAsString() << " at " << "(" << x << ", " << y << ")" << endl;

  // Validate the coordinates and throw exceptions
  if(x < 0 || x > width()) throw invalid_argument("cell coordinates are out of bounds");
  if(y < 0 || y > height()) throw invalid_argument("cell coordinates are out of bounds");
  // Check if the conditions for the cell are met
  if(!cell->canPlaceAt(matrix, x, y)) throw invalid_argument("cell cannot be placed");

  // Place the cell
  matrix[x][y] = cell;
  // Set the helper values
  cell->setLocation(matrix, x, y);
  cout << "City: Built " << cell->getTypeAsString() << " at " << "(" << x << ", " << y << ")" << endl;
}

void City::printMatrix() const {
  for(int y = 0; y < height(); y++) {
    for(int x = 0; x < width(); x++) {
      Cell* cell = matrix[x][y];
      cout << "[" << x << "," << y << "] ";

      cout << setw(17);
      if(cell == NULL) {
        cout << "E";
      } else {
        cout << cell->getTypeAsString();
      }
      cout << " ";
    }

    cout << endl;
  }
}
