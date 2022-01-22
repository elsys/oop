#pragma once

#include <string>
#include <vector>

#include "cell.hh"

using namespace std;

class Leisure : public Cell {
public:
  Leisure(vector<string> type, float maintenanceCost, float requiredPower);
  virtual int getHappiness() const = 0;
  bool canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const;
};

class Mall : public Leisure {
public:
  Mall();
  int getHappiness() const;
};

class Park : public Leisure {
public:
  Park();
  int getHappiness() const;
};
