#pragma once

#include <vector>

using namespace std;

class Cell;

class City {
  vector<vector<Cell*>> matrix;

  // Simple getters for the matrix size
  int width() const;
  int height() const;
  // Helper method that returns all non-empty cells
  vector<Cell*> getAllBuildings() const;
public:
  City(unsigned int width, unsigned int height);

  float getMaintenanceCost() const;
  float getRoadLength() const;
  float getResidentCapacity() const;
  float getRequiredPower() const;
  float getHappiness() const;

  void build(unsigned int x, unsigned int y, Cell* cell);

  void printMatrix() const;
};
