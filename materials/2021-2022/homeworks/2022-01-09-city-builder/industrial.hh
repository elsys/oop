#pragma once

#include <string>
#include <vector>

#include "cell.hh"

using namespace std;

class Industrial : public Cell {
public:
  Industrial(vector<string> type, float maintenanceCost, float requiredPower);
  virtual int getHappiness() const = 0;
  bool canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const;
};

class LightIndustrial : public Industrial {
public:
  LightIndustrial();
  int getHappiness() const;
};

class DenseIndustrial : public Industrial {
public:
  DenseIndustrial();
  int getHappiness() const;
};
