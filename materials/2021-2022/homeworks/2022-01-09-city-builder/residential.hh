#pragma once

#include <string>
#include <vector>

#include "cell.hh"

using namespace std;

class Residential : public Cell {
  int residentCapacity;
public:
  Residential(vector<string> type, float maintenanceCost, float requiredPower, int residentCapacity);
  int getResidentCapacity() const;
  // All residential need to be next to a road
  virtual bool canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const;
};

class LightResidential : public Residential {
public:
  LightResidential();
};

class MediumResidential : public Residential {
public:
  MediumResidential();
};

class DenseResidential : public Residential {
public:
  DenseResidential();
  // DenseResidential need to be next to a road and leisure
  bool canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const;
};
