#pragma once

#include <string>
#include <vector>

using namespace std;

class Cell {
  // Shared attributes across all cell types
  float maintenanceCost;
  float requiredPower;
  // Vector instead of string in order to keep several type values
  // Some places care about the main type(Leisure, Residential) and other places care about the specific type (LightResidential, DenseResidential)
  vector<string> type;
protected:
  // Helper method to find all non-empty neighbors
  const vector<Cell*> getNeighbors(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const;
  // Helper attributes to help the cell discover its neighbors
  const vector<vector<Cell*>>* matrix = NULL;
  int x = -1;
  int y = -1;
public:
  Cell(vector<string> type, float maintenanceCost, float requiredPower);

  // declared as virtual just in case we decide to override them in a child class
  virtual float getMaintenanceCost() const;
  virtual float getRequiredPower() const;

  // Helper methods
  vector<string> getType() const;
  // Join all type strings in one big string
  string getTypeAsString() const;
  // Check if the searched type exists in the vector
  bool hasType(string searched) const;
  // Let each cell type override the condition for placing
  virtual bool canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const = 0;
  // After being placed in the city set values for the helper attributes
  void setLocation(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y);
};
